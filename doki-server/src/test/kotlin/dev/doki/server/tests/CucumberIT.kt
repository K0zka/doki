package dev.doki.server.tests

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import io.quarkus.test.junit.QuarkusTest
import org.junit.Before
import org.junit.runner.RunWith

@QuarkusTest
@CucumberOptions(
		features = ["classpath:dev/doki/server/tests/"],
		glue = ["dev.doki.server.tests.tests"]
)
@RunWith(Cucumber::class)
class CucumberIT {



	@Before
	fun setup() {

	}

}