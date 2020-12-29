package dev.doki.server.rest.exceptions

import dev.doki.model.error.ServiceError
import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

@ApplicationScoped
@Provider
class IllegalArgumentExceptionMapper : ExceptionMapper<IllegalArgumentException> {
	override fun toResponse(exception: IllegalArgumentException): Response =
		Response.status(Response.Status.NOT_ACCEPTABLE).entity(
			ServiceError(exception.message ?: "Not acceptable - no details given.")
		).build()

}