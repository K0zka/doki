package io.github.k0zka.benchmarx.tests

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@CucumberOptions(
		features = ["classpath:io/github/k0zka/benchmarx/tests/"],
		glue = ["io.github.k0zka.benchmarx.tests"]
)
@RunWith(Cucumber::class)
class CucumberIT {
}