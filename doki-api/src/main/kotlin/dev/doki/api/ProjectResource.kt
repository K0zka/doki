package dev.doki.api

import dev.doki.model.project.Project
import org.eclipse.microprofile.openapi.annotations.Operation
import java.util.UUID
import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType.APPLICATION_JSON

@Path("/projects")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
interface ProjectResource {

	@GET
	@Path("/{id}")
	@Operation(summary = "get a project by id")
	fun get(@PathParam("id") id: UUID): Project

	@GET
	@Operation(summary = "list projects")
	fun list(): List<Project>

	@POST
	@Operation(summary = "register a new project")
	fun create(project: Project)

	@DELETE
	@Path("/{id}")
	@Operation(summary = "delete the project")
	fun delete(@PathParam("id") id: UUID)

}