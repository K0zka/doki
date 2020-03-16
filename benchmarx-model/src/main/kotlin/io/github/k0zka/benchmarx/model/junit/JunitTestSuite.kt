package io.github.k0zka.benchmarx.model.junit

data class JunitTestSuite(
		val name : String,
		val time: String,
		val tests : Int,
		val cases : List<JunitTestCase>,
		val properties : Map<String, String>
)