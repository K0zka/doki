package io.github.k0zka.benchmarx.model.cucumber

data class CucumberStep(
		val result: CucumberResult,
		val name: String,
		val line: Int,
		val keyword: String,
		val match: CucumberMatch?,
		val rows: List<CucumberRow>?,
		val comments: List<CucumberComment>?,
		val matchedColumns: List<Int>?
)