package dev.doki.server.rest

import dev.doki.api.JSON
import dev.doki.api.JUnitResource
import dev.doki.api.V1_API_PREFIX
import dev.doki.model.junit.JunitTestSuite
import org.eclipse.microprofile.openapi.annotations.Operation
import java.util.UUID
import javax.ws.rs.Consumes
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType.APPLICATION_JSON

@Path("$V1_API_PREFIX/projects/{projectId}/tests/junit")
@Produces(JSON)
@Consumes(JSON)
class JUnitResourceImpl : JUnitResource {
	@PUT
	@Operation(summary = "Submit JUnit reports")
	override fun submitReports(
			@PathParam("projectId")
			projectId: UUID,
			@QueryParam(value = "token")
			token: String,
			reports: List<JunitTestSuite>
	): String {
		TODO()
	}
}