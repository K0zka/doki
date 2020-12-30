package dev.doki.server.rest.exceptions

import dev.doki.model.error.ServiceError
import io.github.kerubistan.kroki.exceptions.getStackTraceAsString
import org.slf4j.LoggerFactory
import java.util.UUID.randomUUID
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper

abstract class AbstractExceptionMapper<T : Throwable>(
	private val status: Response.Status,
	private val defaultErrorMessage: String
) : ExceptionMapper<T> {

	companion object {
		private val logger = LoggerFactory.getLogger(AbstractExceptionMapper::class.java)
	}

	override fun toResponse(exception: T): Response {
		val id = randomUUID()
		logger.warn(
			"""
			exception response $id
			exception: ${exception.getStackTraceAsString()}
			""".trimIndent())
		return Response.status(status).entity(
			ServiceError(
				message = exception.message ?: defaultErrorMessage,
				id = id
			)
		).build()
	}

}