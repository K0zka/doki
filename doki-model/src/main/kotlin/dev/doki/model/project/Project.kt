package dev.doki.model.project

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID
import java.util.UUID.randomUUID

data class Project(
		@get:JsonProperty("_id")
		val id: UUID = randomUUID(),
		@get:JsonProperty("name")
		val name: String,
		@get:JsonProperty("url")
		val url: String,
		@get:JsonProperty("registered-at")
		val registered: Long,
		@get:JsonProperty("logo-url")
		val logoUrl: String
)