package dev.doki.api

import dev.doki.model.jmh.JmhBenchmarkResult
import org.eclipse.microprofile.openapi.annotations.Operation
import java.util.UUID
import javax.ws.rs.Consumes
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam

@Path("$V1_API_PREFIX/projects/{projectId}/benchmarks/jmh")
@Produces(JSON)
@Consumes(JSON)
interface JmhResource : ProjectDataResource<JmhBenchmarkResult> {
	@PUT
	@Operation(summary = "Submit JMH reports")
	override fun submitReports(
		@PathParam(value = "projectId") projectId: UUID,
		@QueryParam(value = "token") token: String,
		reports: List<JmhBenchmarkResult>
	): String
}