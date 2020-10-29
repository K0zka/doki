package dev.doki.model.cucumber

data class CucumberResult(
		val duration: Int,
		val status: CucumberStatus
)