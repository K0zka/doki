package dev.doki.api

import dev.doki.model.cucumber.CucumberReport
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition
import org.eclipse.microprofile.openapi.annotations.info.Info
import java.util.UUID
import javax.ws.rs.Consumes
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

@OpenAPIDefinition(
		info = Info(title = "Cucumber resource", description = "Allows uploading cucumber test execution reports", version = "1.0")
)
@Path("/projects/{projectId}/tests/cucumber")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
interface CucumberResource : ProjectDataResource<CucumberReport> {

	@PUT
	override fun submitReports(
			@PathParam("projectId")
			projectId: UUID,
			@QueryParam(value = "token")
			token: String,
			reports: List<CucumberReport>
	): String

}