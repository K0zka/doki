package dev.doki.server.rest

import dev.doki.api.JSON
import dev.doki.api.StatisticsResource
import dev.doki.api.V1_API_PREFIX
import dev.doki.server.service.StatisticsService
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces

@Path("$V1_API_PREFIX/statistics")
@Produces(JSON)
@Consumes(JSON)
class StatisticsResourceImpl : StatisticsResource {

	@Inject
	lateinit var statisticsService: StatisticsService

	@GET
	override fun getStatisticsOverview() = statisticsService.getStatisticsOverview()

}