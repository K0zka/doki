package io.github.k0zka.benchmarx.cli.client

import io.github.k0zka.benchmarx.api.JUnitResource
import org.junit.Assert.*
import org.junit.Test

class ClientKtTest {
	@Test
	fun projectResource() {
		assertNotNull( projectResource<JUnitResource>("http://localhost:8080/") )
	}
}