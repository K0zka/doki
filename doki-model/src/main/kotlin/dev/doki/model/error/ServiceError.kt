package dev.doki.model.error

import java.util.UUID
import java.util.UUID.randomUUID

data class ServiceError(
	val message : String,
	val id : UUID = randomUUID()
)
