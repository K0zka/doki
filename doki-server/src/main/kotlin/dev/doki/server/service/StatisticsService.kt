package dev.doki.server.service

import dev.doki.model.statistics.StatisticsOverview

interface StatisticsService {
	fun getStatisticsOverview(): StatisticsOverview
}