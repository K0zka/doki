package io.github.k0zka.benchmarx.tests

import io.cucumber.java8.En

class CommonReportSteps : En {
	init {
		Then("^we will see the (\\S+) report in the app$") {
			reportType: String ->
			TODO()
		}
	}
}