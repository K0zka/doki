package io.github.k0zka.benchmarx.tests

import io.cucumber.java8.En

class CommonUploadSteps : En {
	init {
		When("^we upload the (\\S+) test results$") {
			reportType : String ->
			TODO()
		}
	}
}