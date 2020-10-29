package io.github.k0zka.benchmarx.cli

import org.junit.Assert.*
import org.junit.Test

class BenchmarxCliTest {
	@Test
	fun main() {
		BenchmarxCli.main(argv = arrayOf("--server-url", "http://localhost:8080", "--token", "TEST-TOKEN"))
	}
}