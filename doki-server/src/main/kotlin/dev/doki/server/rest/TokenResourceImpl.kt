package dev.doki.server.rest

import dev.doki.api.TokenResource
import dev.doki.model.project.Token
import dev.doki.server.service.TokenService
import java.util.UUID
import javax.inject.Inject
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
class TokenResourceImpl : TokenResource {
	@Inject
	lateinit var tokenService: TokenService

	@POST
	override fun createToken(@PathParam("projectId") projectId: UUID): Token = tokenService.generateToken(projectId)

	@DELETE
	override fun removeToken(@PathParam(value = "projectId") projectId: UUID, @QueryParam("token") token: String) {
		tokenService.removeToken(projectId, token)
	}

	@GET
	override fun listProjectTokens(@PathParam("projectId") projectId: UUID): List<Token> =
			tokenService.listByProject(projectId)
}