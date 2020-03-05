package io.github.k0zka.benchmarx.rest

import io.github.k0zka.benchmarx.api.JmhResource
import io.github.k0zka.benchmarx.model.jmh.JmhBenchmarkResult
import io.github.k0zka.benchmarx.service.JmhService
import io.github.k0zka.benchmarx.service.TokenService
import java.util.UUID
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

@Path("/projects/{projectId}/benchmarks/jmh")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class JmhResourceImpl : JmhResource {

	@Inject
	lateinit var jmhService: JmhService
	@Inject
	lateinit var tokenService: TokenService

	@PUT
	override fun submitReports(
            @PathParam("projectId") projectId: UUID,
			@QueryParam("token") token : String,
            reports: List<JmhBenchmarkResult>
    ): String {
		tokenService.checkToken(projectId, token)
		TODO()
	}

}
