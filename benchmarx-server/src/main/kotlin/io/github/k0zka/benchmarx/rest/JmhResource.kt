package io.github.k0zka.benchmarx.rest

import io.github.k0zka.benchmarx.model.jmh.JmhBenchmarkResult
import io.github.k0zka.benchmarx.service.JmhService
import java.util.UUID
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType.APPLICATION_JSON

@Path("/projects/{projectId}/benchmarks/jmh")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
class JmhResource {

	@Inject
	lateinit var jmhService: JmhService

	@PUT
	fun submitReports(
            @PathParam("projectId") projectId: UUID,
			@QueryParam("token") token : String,
            reports: List<JmhBenchmarkResult>
    ): String = TODO()

}
