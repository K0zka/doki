package io.github.k0zka.benchmarx.model.cucumber

data class CucumberMatch(
		val location: String,
		val arguments: List<CucumberArgument>?
)