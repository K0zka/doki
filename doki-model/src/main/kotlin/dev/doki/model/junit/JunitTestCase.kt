package dev.doki.model.junit

data class JunitTestCase(val name: String, val time: Double, val message: String? = null, val excType: String? = null,
						 val trace: String? = null, val outcome: Outcome)