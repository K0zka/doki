package dev.doki.server.rest.exceptions

import dev.doki.model.error.ServiceError
import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

@ApplicationScoped
@Provider
class NotImplementedExceptionMapper : ExceptionMapper<NotImplementedError> {
	override fun toResponse(exception: NotImplementedError): Response =
		Response.status(Response.Status.NOT_IMPLEMENTED).entity(
			ServiceError(exception.message ?: "Not implemented - no details given.")
		).build()
}