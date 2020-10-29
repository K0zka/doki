package dev.doki.server.tests

import io.cucumber.java8.En
import io.cucumber.java8.Scenario

class ApplicationSteps : En {

	lateinit var scenario: Scenario

	init {

		Before {
			scenario ->
			this.scenario = scenario
		}

		Given("a running benchmarx app") {

		}
	}
}