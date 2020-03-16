package io.github.k0zka.benchmarx.api

import org.eclipse.microprofile.openapi.annotations.Operation
import java.util.UUID
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/projects/{projectId}/statistics")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
interface UsageService {
	@GET
	@Path("total")
	@Operation(summary = "Get the total storage space used by a project")
	fun totalSpace(@PathParam("projectId") projectId : UUID)
}