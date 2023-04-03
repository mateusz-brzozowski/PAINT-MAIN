package org.example.session

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class SessionApplicationTest extends Specification {

	def 'Should load context correctly'() {
		expect:
		true
	}
}
