package dev.doki.model.gatling

import dev.doki.model.generic.Versioned

data class GatlingReport(
		override val branch: String?,
		override val version: String?,
		override val recorded: Long?,
		override val submitted: Long?
) : Versioned