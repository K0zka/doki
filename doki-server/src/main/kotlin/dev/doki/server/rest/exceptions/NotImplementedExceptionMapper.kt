package dev.doki.server.rest.exceptions

import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.core.Response
import javax.ws.rs.ext.Provider

@ApplicationScoped
@Provider
class NotImplementedExceptionMapper : AbstractExceptionMapper<NotImplementedError>(
	Response.Status.NOT_IMPLEMENTED,
	"Not implemented - no details given."
)