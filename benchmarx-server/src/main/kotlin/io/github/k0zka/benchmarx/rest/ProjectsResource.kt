package io.github.k0zka.benchmarx.rest

import io.github.k0zka.benchmarx.model.project.Project
import io.github.k0zka.benchmarx.service.ProjectService
import org.eclipse.microprofile.openapi.annotations.Operation
import java.util.UUID
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType.APPLICATION_JSON

@Path("/projects")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
class ProjectsResource {

	@Inject
	lateinit var service: ProjectService

	@GET
	@Path("/{id}")
	@Operation(summary = "get a project by id")
	fun get(@PathParam("id") id : UUID): Project = service.getById(id)

	@GET
	@Operation(summary = "list projects")
	fun list(): List<Project> = service.list()

	@PUT
	@Operation(summary = "register a new project")
	fun create(project: Project) = service.create(project)

}