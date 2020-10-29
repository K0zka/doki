package dev.doki.model.junit

data class JunitTestSuite(
		val name: String,
		val time: String,
		val tests: Int,
		val cases: List<JunitTestCase>,
		val properties: Map<String, String>
)