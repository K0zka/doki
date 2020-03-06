package io.github.k0zka.benchmarx.model.junit

data class JunitTestCase(val name: String, val time: Double, val message: String, val excType: String,
						 val trace: String, val outcome: Outcome)