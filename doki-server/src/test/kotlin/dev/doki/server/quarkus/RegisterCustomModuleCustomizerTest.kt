package dev.doki.server.quarkus

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import dev.doki.model.project.Project
import org.junit.Test

class RegisterCustomModuleCustomizerTest {

	@Test
	fun customize() {
		val mapper = ObjectMapper().apply {
			RegisterCustomModuleCustomizer.customize(this)
		}
		mapper.readValue<Project>("""
			{
			  "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
			  "logo-url": "string",
			  "name": "string",
			  "registered": 0,
			  "url": "string"
			}
		""".trimIndent())
	}
}