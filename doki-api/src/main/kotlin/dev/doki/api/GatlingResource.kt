package dev.doki.api

import javax.ws.rs.Consumes
import javax.ws.rs.Path
import javax.ws.rs.Produces

@Path("$V1_API_PREFIX/projects/{projectId}/benchmarks/gatling")
@Produces(JSON)
@Consumes(JSON)
interface GatlingResource : ProjectDataResource<Unit> {
}