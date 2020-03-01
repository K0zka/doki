package io.github.k0zka.benchmarx.model.jmh

import io.github.k0zka.benchmarx.model.generic.Versioned

data class JmhBenchmarkResult(
		val jmhVersion : String,
		val benchmark: String,
		val mode: String,
		val threads : Int,
		val forks : Int,
		val jvm : String,
		val jvmArgs : List<String>,
		val jdkVersion : String,
		val vmName : String,
		val vmVersion : String,
		val warmupTime: String,
		val warmupBatchSize: Int,
		val measurementIterations: Int,
		val measurementTime: String,
		val measurementBatchSize: Int,
		val params : Map<String, String> = mapOf(),
		val primaryMetric: JmhMetric,
		override val branch: String,
		override val version: String,
		override val recorded: Long?,
		override val submitted: Long
) : Versioned