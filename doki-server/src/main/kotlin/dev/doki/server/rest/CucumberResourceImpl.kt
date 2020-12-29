package dev.doki.server.rest

import dev.doki.api.CucumberResource
import dev.doki.api.JSON
import dev.doki.api.V1_API_PREFIX
import dev.doki.model.cucumber.CucumberReport
import dev.doki.server.service.CucumberService
import dev.doki.server.service.TokenService
import java.util.UUID
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam

@Path("$V1_API_PREFIX/projects/{projectId}/tests/cucumber")
@Produces(JSON)
@Consumes(JSON)
class CucumberResourceImpl : CucumberResource {

	@Inject
	lateinit var cucumberService: CucumberService

	@Inject
	lateinit var tokenService: TokenService

	@PUT
	override fun submitReports(
		@PathParam("projectId")
		projectId: UUID,
		@QueryParam(value = "token")
		token: String,
		reports: List<CucumberReport>
	): String = tokenService.doPrivileged(projectId, token) {
		TODO("not implemented")
	}
}