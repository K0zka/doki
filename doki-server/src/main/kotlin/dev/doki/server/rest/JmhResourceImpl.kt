package dev.doki.server.rest

import dev.doki.api.JSON
import dev.doki.api.JmhResource
import dev.doki.api.V1_API_PREFIX
import dev.doki.model.jmh.JmhBenchmarkResult
import dev.doki.server.service.JmhService
import dev.doki.server.service.TokenService
import java.util.UUID
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam

@Path("$V1_API_PREFIX/projects/{projectId}/benchmarks/jmh")
@Produces(JSON)
@Consumes(JSON)
class JmhResourceImpl : JmhResource {

	@Inject
	lateinit var jmhService: JmhService

	@Inject
	lateinit var tokenService: TokenService

	@PUT
	override fun submitReports(
			@PathParam("projectId") projectId: UUID,
			@QueryParam("token") token: String,
			reports: List<JmhBenchmarkResult>
	): String {
		tokenService.checkToken(projectId, token)
		TODO()
	}

}
