package io.github.k0zka.benchmarx.model.project

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

data class Token(
		@JsonProperty("_id")
		val id: UUID,
		val projectId: UUID,
		val token: String,
		val generated: Long
)