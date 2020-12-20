package dev.doki.server.rest

import dev.doki.api.JSON
import dev.doki.api.ProjectResource
import dev.doki.api.V1_API_PREFIX
import dev.doki.model.project.Project
import dev.doki.server.service.ProjectService
import org.eclipse.microprofile.openapi.annotations.Operation
import java.util.UUID
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("$V1_API_PREFIX/projects")
@Produces(JSON)
@Consumes(JSON)
class ProjectsResouryceImpl : ProjectResource {

	@Inject
	lateinit var service: ProjectService

	@GET
	@Path("/{id}")
	@Operation(summary = "get a project by id")
	override fun get(@PathParam("id") id: UUID): Project = service.getById(id)

	@GET
	@Operation(summary = "list projects")
	override fun list(): List<Project> = service.list()

	@POST
	@Operation(summary = "register a new project")
	override fun create(project: Project) = service.create(project)

	@DELETE
	@Path("/{id}")
	@Operation(summary = "delete the project")
	override fun delete(@PathParam("id") id: UUID) {
		service.delete(id)
	}

}