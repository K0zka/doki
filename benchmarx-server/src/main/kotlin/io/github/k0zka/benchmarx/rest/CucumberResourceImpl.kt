package io.github.k0zka.benchmarx.rest

import io.github.k0zka.benchmarx.api.CucumberResource
import io.github.k0zka.benchmarx.model.cucumber.CucumberReport
import io.github.k0zka.benchmarx.service.CucumberService
import java.util.UUID
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

@Path("/projects/{projectId}/tests/cucumber")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class CucumberResourceImpl : CucumberResource {

	@Inject
	lateinit var cucumberService: CucumberService

	@PUT
	override fun submitReports(
			@PathParam("projectId")
			projectId: UUID,
			@QueryParam(value = "token")
			token: String,
			reports: List<CucumberReport>
	): String {
		TODO("not implemented")
	}
}