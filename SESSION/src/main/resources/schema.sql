CREATE TABLE IF NOT EXISTS languages (
    language_id INT NOT NULL AUTO_INCREMENT,
    code VARCHAR(3) NOT NULL,
    name VARCHAR(50) NOT NULL,
    flag_url VARCHAR(512)
);

CREATE TABLE IF NOT EXISTS sessions (
    session_id BIGINT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    language_id INT NOT NULL,
    word_length INT,
    word_number INT,
    created_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS guesses (
    guess_id BIGINT NOT NULL AUTO_INCREMENT,
    session_id BIGINT NOT NULL,
    guess_number INT NOT NULL,
    guess VARCHAR(50) NOT NULL,
    created_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS words (
    word_id BIGINT NOT NULL AUTO_INCREMENT,
    language_id INT NOT NULL,
    word_length INT NOT NULL,
    word_number INT NOT NULL,
    word VARCHAR(50) NOT NULL
);
