package dev.doki.api

import org.eclipse.microprofile.openapi.annotations.Operation
import java.util.UUID
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("$V1_API_PREFIX/projects/{projectId}/statistics")
@Produces(JSON)
@Consumes(JSON)
interface UsageService {
	@GET
	@Path("total")
	@Operation(summary = "Get the total storage space used by a project")
	fun totalSpace(@PathParam("projectId") projectId: UUID)
}