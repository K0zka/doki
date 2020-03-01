package io.github.k0zka.benchmarx.rest

import io.github.k0zka.benchmarx.model.project.Token
import io.github.k0zka.benchmarx.service.TokenService
import java.util.UUID
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/projects/{projectId}/tokens")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class TokenResource {
	@Inject
	lateinit var tokenService: TokenService

	@GET
	fun listProjectTokens(@PathParam("projectId") projectId: UUID): List<Token> = tokenService.listByProject(projectId)
}