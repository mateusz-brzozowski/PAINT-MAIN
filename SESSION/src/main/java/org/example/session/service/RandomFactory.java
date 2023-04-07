package org.example.session.service;

import java.util.Random;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class RandomFactory {

	@Bean
	public Random random() {
		return new Random();
	}
}
