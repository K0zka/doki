package io.github.k0zka.benchmarx.model.jmh

import java.math.BigDecimal

data class JmhMetric(
		val score: BigDecimal,
		val scoreError: BigDecimal,
		val scoreConfidence: List<BigDecimal>,
		val scorePercentiles: Map<String, BigDecimal>,
		val scoreUnit: String,
		val rawData: List<List<BigDecimal>>
)