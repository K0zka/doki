package io.github.k0zka.benchmarx.model.jmh

import io.github.k0zka.benchmarx.model.generic.Versioned

data class JmhBenchmarkResult(
		val jmhVersion: String,
		val benchmark: String,
		val mode: String,
		val threads: Int,
		val forks: Int,
		val jvm: String,
		val jvmArgs: List<String>,
		val jdkVersion: String,
		val vmName: String? = null,
		val vmVersion: String,
		val warmupIterations: Int,
		val warmupTime: String,
		val warmupBatchSize: Int,
		val measurementIterations: Int,
		val measurementTime: String,
		val measurementBatchSize: Int,
		val params: Map<String, String> = mapOf(),
		val primaryMetric: JmhMetric,
		val secondaryMetrics: Map<String, Any> = mapOf(),
		override val branch: String? = null,
		override val version: String? = null,
		override val recorded: Long? = null,
		override val submitted: Long? = null
) : Versioned