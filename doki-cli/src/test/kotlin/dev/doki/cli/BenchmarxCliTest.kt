package dev.doki.cli

import org.junit.Test

class BenchmarxCliTest {
	@Test
	fun main() {
		DokiCli.main(argv = arrayOf("--server-url", "http://localhost:8080", "--token", "TEST-TOKEN"))
	}
}