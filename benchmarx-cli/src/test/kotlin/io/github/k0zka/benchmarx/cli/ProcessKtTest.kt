package io.github.k0zka.benchmarx.cli

import io.github.k0zka.benchmarx.model.junit.Outcome
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class ProcessKtTest {

	@Test
	fun findJunitResults() {
		val junitResults = findJunitResults(File("src/test/resources/junit/ProcessKtTest/findJunitResults"))
		assertEquals("io.github.k0zka.benchmarx.cli.ProcessKtTest", junitResults.single().name)
		assertEquals(4, junitResults.single().cases.size)
		assertTrue(junitResults.single().cases.all { it.outcome == Outcome.ERROR })
		assertTrue(junitResults.single().cases.all { it.message == "An operation is not implemented." })
		assertTrue(junitResults.single().cases.all { it.excType == "kotlin.NotImplementedError" })
		assertTrue(junitResults.single().cases.all { it.trace != null })
	}

	@Test
	fun findSkippedTests() {
		val junitResults = findJunitResults(File("src/test/resources/junit/ProcessKtTest/findSkippedTests"))
		junitResults.single().cases.single { it.outcome == Outcome.FAIL }.apply {
			assertEquals(this.name, "failedTest")
		}
		junitResults.single().cases.single { it.outcome == Outcome.IGNORE }.apply {
			assertEquals(this.name, "assumptionFailed")
		}
	}

//	@Test
//	fun findCucumberResults() {
//		TODO()
//	}
//
//	@Test
//	fun findJmhResults() {
//		TODO()
//	}
//
//	@Test
//	fun findGatlingResults() {
//		TODO()
//	}
}