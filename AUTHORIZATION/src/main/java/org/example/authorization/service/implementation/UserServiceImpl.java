package org.example.authorization.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.authorization.entity.UserEntity;
import org.example.authorization.exception.IncorrectLogin;
import org.example.authorization.model.LoginRequest;
import org.example.authorization.model.RegisterRequest;
import org.example.authorization.model.User;
import org.example.authorization.repository.UserRepository;
import org.example.authorization.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private static final int SALT_LENGTH = 16;
    private static final int HASH_ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;
    private static final String HASH_ALGORITHM = "PBKDF2WithHmacSHA512";

    @Override
    public Mono<User> login(LoginRequest request) {
        return userRepository.findByLogin(request.getLogin())
                .mapNotNull(userEntity -> {
                    String salt = userEntity.getSalt();
                    String hash = generateHash(request.getPassword(), salt);
                    if (hash == null)
                        return null;
                    if (!hash.equals(userEntity.getPasswordHash()))
                        return null;
                    return User.builder()
                                    .id(userEntity.getUserId())
                                    .login(userEntity.getLogin())
                                    .build();
                        }
                ).switchIfEmpty(Mono.error(IncorrectLogin::new));
    }

    @Override
    public Mono<Boolean> register(RegisterRequest request) {
        if (!request.getPassword().equals(request.getConfirmPassword()))
            return Mono.just(false);
        String salt = generateSalt();
        return userRepository.save(
                UserEntity
                        .builder()
                        .login(request.getLogin())
                        .passwordHash(generateHash(request.getPassword(), salt))
                        .salt(salt)
                        .build()
        ).map(Objects::nonNull);
    }

    private String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    private String generateHash(String password, String salt) {
        try {
            char[] passwordChars = password.toCharArray();
            byte[] saltBytes = Base64.getDecoder().decode(salt);

            PBEKeySpec spec = new PBEKeySpec(passwordChars, saltBytes, HASH_ITERATIONS, KEY_LENGTH);
            SecretKeyFactory factory = SecretKeyFactory.getInstance(HASH_ALGORITHM);
            byte[] hashBytes = factory.generateSecret(spec).getEncoded();

            return Base64.getEncoder().encodeToString(hashBytes);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException();
        }
    }
}
