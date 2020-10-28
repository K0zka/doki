package io.github.k0zka.benchmarx.tests

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import io.quarkus.test.junit.QuarkusTest
import org.junit.Before
import org.junit.runner.RunWith

@QuarkusTest
@CucumberOptions(
		features = ["classpath:io/github/k0zka/benchmarx/tests/"],
		glue = ["io.github.k0zka.benchmarx.tests"]
)
@RunWith(Cucumber::class)
class CucumberIT {



	@Before
	fun setup() {

	}

}