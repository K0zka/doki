package dev.doki.model.generic

interface Versioned {
	val branch: String?
	val version: String?
	val recorded: Long?
	val submitted: Long?
}