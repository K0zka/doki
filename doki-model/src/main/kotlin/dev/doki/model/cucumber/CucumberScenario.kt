package dev.doki.model.cucumber

data class CucumberScenario(
		val name: String,
		val line: Int,
		val type: String,
		val description: String,
		val id: String,
		val keyword: String,
		val before: List<CucumberAction>?,
		val after: List<CucumberAction>?,
		val steps: List<CucumberStep> = listOf(),
		val comments: List<CucumberComment>?
)