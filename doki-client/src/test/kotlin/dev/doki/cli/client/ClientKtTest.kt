package dev.doki.cli.client

import dev.doki.api.JUnitResource
import org.junit.Assert.*
import org.junit.Test

class ClientKtTest {
	@Test
	fun restResource() {
		assertNotNull( restResource<JUnitResource>("http://localhost:8080/") )
	}
}