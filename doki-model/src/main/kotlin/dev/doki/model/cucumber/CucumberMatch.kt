package dev.doki.model.cucumber

data class CucumberMatch(
		val location: String,
		val arguments: List<CucumberArgument>?
)