package io.github.k0zka.benchmarx.model.cucumber

import io.github.k0zka.benchmarx.model.generic.Versioned

data class CucumberReport(
		override val branch: String?,
		override val version: String?,
		override val recorded: Long?,
		override val submitted: Long,
		val features : List<CucumberFeature>
) : Versioned