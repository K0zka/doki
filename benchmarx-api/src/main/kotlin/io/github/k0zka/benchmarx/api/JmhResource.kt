package io.github.k0zka.benchmarx.api

import io.github.k0zka.benchmarx.model.jmh.JmhBenchmarkResult
import org.eclipse.microprofile.openapi.annotations.Operation
import java.util.UUID
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
interface JmhResource : ProjectDataResource<JmhBenchmarkResult> {
	@PUT
	@Operation(summary = "Submit JMH reports")
	override fun submitReports(@PathParam(value = "projectId") projectId: UUID, @QueryParam(value = "token") token: String,
							   reports: List<JmhBenchmarkResult>): String
}