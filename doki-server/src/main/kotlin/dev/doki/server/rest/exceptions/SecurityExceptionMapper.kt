package dev.doki.server.rest.exceptions

import dev.doki.model.error.ServiceError
import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

@ApplicationScoped
@Provider
class SecurityExceptionMapper : ExceptionMapper<SecurityException> {
	override fun toResponse(exception: SecurityException): Response =
		Response.status(Response.Status.UNAUTHORIZED).entity(
			ServiceError(exception.message ?: "Permission denied - no details given.")
		).build()

}