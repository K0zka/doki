package dev.doki.server.service

import com.mongodb.client.MongoClient
import dev.doki.model.statistics.StatisticsOverview
import io.github.kerubistan.kroki.time.now
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class StatisticsServiceImpl : StatisticsService {

	@Inject
	lateinit var mongoClient: MongoClient

	override fun getStatisticsOverview(): StatisticsOverview =
		// TODO
		StatisticsOverview(
			lastCalculated = now(),
			totalProjects = mongoClient.project.countDocuments(),
			totalUsers = 1
		)

}