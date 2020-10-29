package io.github.k0zka.benchmarx.model.gatling

import io.github.k0zka.benchmarx.model.generic.Versioned

data class GatlingReport(
		override val branch: String?,
		override val version: String?,
		override val recorded: Long?,
		override val submitted: Long?
) : Versioned