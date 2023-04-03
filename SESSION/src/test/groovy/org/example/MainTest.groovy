package org.example

import spock.lang.Specification


class MainTest extends Specification {

	def 'Should add two numbers correctly'() {
		expect:
		first + second == result

		where:
		first | second || result
		1     | 2      || 3
		2     | 2      || 4
		2     | -2     || 0
		-1    | 2      || 1
	}
}
