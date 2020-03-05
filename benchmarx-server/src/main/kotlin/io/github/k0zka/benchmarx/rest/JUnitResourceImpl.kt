package io.github.k0zka.benchmarx.rest

import io.github.k0zka.benchmarx.api.JUnitResource
import io.github.k0zka.benchmarx.model.junit.JunitTestSuite
import org.eclipse.microprofile.openapi.annotations.Operation
import java.util.UUID
import javax.ws.rs.Consumes
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType.APPLICATION_JSON

@Path("/projects/{projectId}/tests/junit")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
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