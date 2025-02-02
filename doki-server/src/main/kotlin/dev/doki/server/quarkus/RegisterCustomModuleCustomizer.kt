package dev.doki.server.quarkus

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.quarkus.jackson.ObjectMapperCustomizer
import javax.inject.Singleton

@Singleton
object RegisterCustomModuleCustomizer : ObjectMapperCustomizer {

	override fun customize(objectMapper: ObjectMapper) {
		objectMapper.apply {
			registerModule(KotlinModule(strictNullChecks = true))
			enable(MapperFeature.AUTO_DETECT_CREATORS)
			disable(SerializationFeature.INDENT_OUTPUT)
			disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
		}
	}
}