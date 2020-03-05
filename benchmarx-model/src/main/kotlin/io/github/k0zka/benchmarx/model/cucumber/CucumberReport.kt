package io.github.k0zka.benchmarx.model.cucumber

import io.github.k0zka.benchmarx.model.generic.Versioned

data class CucumberReport(
		// TODO
		override val branch: String,
		override val version: String,
		override val recorded: Long?,
		override val submitted: Long
) : Versioned