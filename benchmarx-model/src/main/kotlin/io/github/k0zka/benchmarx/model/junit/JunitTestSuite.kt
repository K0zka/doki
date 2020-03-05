package io.github.k0zka.benchmarx.model.junit

data class JunitTestSuite(
		val name : String,
		val time: String,
		val tests : Int,
		val suites : List<JunitTestSuite>,
		val properties : Map<String, String>
)