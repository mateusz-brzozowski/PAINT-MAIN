package org.example.session.controller

import org.example.session.entity.WordEntity
import org.example.session.model.Session
import org.example.session.repository.SessionRepository
import org.example.session.repository.WordRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@AutoConfigureMockMvc
class WordleControllerIntegrationTest extends Specification {

	@Autowired
	MockMvc mvc

	@Autowired
	WordRepository wordRepository

	@Autowired
	SessionRepository sessionRepository

	def 'cleanup'() {
		wordRepository.deleteAll()
		sessionRepository.deleteAll()
	}

	def 'Insert word'() {
		var entity = WordEntity.builder().languageId(1).length(5).number(1).word("plane").build()
		wordRepository.save(entity).block()
	}

	def 'Should initialize session correctly'() {
		given:
		'Insert word'()

		expect:
		var response = (Session) mvc.perform(
				MockMvcRequestBuilders.get("/wordle?languageId=1")
						.header("wordLength", 5)
		)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn()
				.asyncResult

		response.getUserId() == 1
		response.getWordLength() == 5
		response.getLanguageId() == 1
	}
}