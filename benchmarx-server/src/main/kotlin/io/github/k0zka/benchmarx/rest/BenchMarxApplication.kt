package io.github.k0zka.benchmarx.rest

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition
import org.eclipse.microprofile.openapi.annotations.info.Contact
import org.eclipse.microprofile.openapi.annotations.info.Info
import org.eclipse.microprofile.openapi.annotations.info.License
import javax.ws.rs.core.Application

@OpenAPIDefinition(
		info = Info(
				title="Benchmarx API",
				version = "0.1",
				contact = Contact(
						name = "Developer",
						url = "http://github.com/K0zka"),
				license = License(
						name = "Apache 2.0",
						url = "http://www.apache.org/licenses/LICENSE-2.0.html"))
)
class BenchMarxApplication : Application()