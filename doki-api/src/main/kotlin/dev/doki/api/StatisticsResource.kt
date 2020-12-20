package dev.doki.api

import dev.doki.model.statistics.StatisticsOverview
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces

@Path("$V1_API_PREFIX/statistics")
@Produces(JSON)
@Consumes(JSON)
interface StatisticsResource {
	@GET
	fun getStatisticsOverview() : StatisticsOverview
}