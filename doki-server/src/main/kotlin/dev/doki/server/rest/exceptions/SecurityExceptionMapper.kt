package dev.doki.server.rest.exceptions

import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.core.Response
import javax.ws.rs.ext.Provider

@ApplicationScoped
@Provider
class SecurityExceptionMapper : AbstractExceptionMapper<SecurityException>(
	Response.Status.UNAUTHORIZED,
	"Permission denied - no details given."
)