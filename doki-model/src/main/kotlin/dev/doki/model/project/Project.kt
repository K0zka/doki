package dev.doki.model.project

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID
import java.util.UUID.randomUUID

data class Project @JsonCreator constructor(
		@JsonProperty("_id")
		val id: UUID = randomUUID(),
		@JsonProperty("name")
		val name: String,
		@JsonProperty("url")
		val url: String,
		@JsonProperty("registered-at")
		val registered: Long,
		@JsonProperty("logo-url")
		val logoUrl: String
)