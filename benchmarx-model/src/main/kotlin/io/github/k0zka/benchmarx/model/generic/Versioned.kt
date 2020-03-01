package io.github.k0zka.benchmarx.model.generic

interface Versioned {
	val branch : String
	val version : String
	val recorded : Long?
	val submitted : Long
}