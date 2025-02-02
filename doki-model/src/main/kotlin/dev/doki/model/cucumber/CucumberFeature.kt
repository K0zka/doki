package dev.doki.model.cucumber

data class CucumberFeature(
		val name: String,
		val line: Int,
		val description: String,
		val id: String,
		val keyword: String,
		val uri: String,
		val elements: List<CucumberScenario>
)