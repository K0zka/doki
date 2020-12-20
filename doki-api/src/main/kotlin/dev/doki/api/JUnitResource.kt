package dev.doki.api

import dev.doki.model.junit.JunitTestSuite
import org.eclipse.microprofile.openapi.annotations.Operation
import java.util.UUID
import javax.ws.rs.Consumes
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam

@Path("$V1_API_PREFIX/projects/{projectId}/tests/junit")
@Produces(JSON)
@Consumes(JSON)
interface JUnitResource : ProjectDataResource<JunitTestSuite> {
	@PUT
	@Operation(summary = "Submit JUnit reports")
	override fun submitReports(
		@PathParam("projectId")
		projectId: UUID,
		@QueryParam(value = "token")
		token: String,
		reports: List<JunitTestSuite>
	): String

}