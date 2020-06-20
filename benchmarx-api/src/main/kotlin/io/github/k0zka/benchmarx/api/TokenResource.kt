package io.github.k0zka.benchmarx.api

import io.github.k0zka.benchmarx.model.project.Token
import org.eclipse.microprofile.openapi.annotations.Operation
import java.util.UUID
import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

@Path("/projects/{projectId}/tokens")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
interface TokenResource {
	@GET
	@Operation(summary = "list tokens of a project")
	fun listProjectTokens(@PathParam(value = "projectId") projectId: UUID): List<Token>

	@POST
	@Operation(summary = "create a token")
	fun createToken(@PathParam(value = "projectId") projectId: UUID): Token

	@DELETE
	@Operation(summary = "remove a token")
	fun removeToken(@PathParam(value = "projectId") projectId: UUID, @QueryParam("token") token: String)

}