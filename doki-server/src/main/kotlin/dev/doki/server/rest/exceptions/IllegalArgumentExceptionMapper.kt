package dev.doki.server.rest.exceptions

import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.core.Response
import javax.ws.rs.ext.Provider

@ApplicationScoped
@Provider
class IllegalArgumentExceptionMapper : AbstractExceptionMapper<IllegalArgumentException>(
	Response.Status.NOT_ACCEPTABLE,
	"Not acceptable - no details given."
)