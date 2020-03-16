package io.github.k0zka.benchmarx.cli

import com.fasterxml.aalto.stax.InputFactoryImpl
import io.github.k0zka.benchmarx.model.cucumber.CucumberReport
import io.github.k0zka.benchmarx.model.jmh.JmhBenchmarkResult
import io.github.k0zka.benchmarx.model.junit.JunitTestCase
import io.github.k0zka.benchmarx.model.junit.JunitTestSuite
import io.github.k0zka.benchmarx.model.junit.Outcome
import io.github.kerubistan.kroki.collections.toList
import java.io.File
import javax.xml.stream.events.Attribute
import javax.xml.stream.events.Characters
import javax.xml.stream.events.EndElement
import javax.xml.stream.events.StartElement

private val xmlInputFactory by lazy {
	InputFactoryImpl().apply {
		configureForSpeed()
	}
}

fun findJunitResults(directory: File) : List<JunitTestSuite>
		= directory
			.listFiles { _, name -> name.endsWith(".xml") }
			.mapNotNull {
				var suite : JunitTestSuite? = null
				var case : JunitTestCase? = null
				xmlInputFactory.createXMLEventReader(it).let {
					reader ->
					reader.forEach { event ->
						when(event) {
							is StartElement -> {
								val atts = event.attributes.toList().filterIsInstance<Attribute>().associateBy {
									it.name.localPart
								}
								when(event.name.localPart) {
									"testsuite" -> suite = JunitTestSuite(
											name = atts.getValue("name").value,
											time = atts.getValue("time").value,
											tests = atts.getValue("tests").value.toInt(),
											cases = listOf(),
											properties = mapOf()
									)
									"testcase" -> case = JunitTestCase(
											name = atts.getValue("name").value,
											time = atts.getValue("time").value.toDouble(),
											outcome = Outcome.PASS
											// actually not known yet, but leave it like this if no error tag
									)
									"failure" -> case = case?.copy(
											outcome = Outcome.FAIL,
											excType = atts["type"]?.value,
											message = atts["message"]?.value
									)
									"error" -> case = case?.copy(
											outcome = Outcome.ERROR,
											excType = atts["type"]?.value,
											message = atts["message"]?.value
									)
									"skipped" -> case = case?.copy(
											outcome = Outcome.IGNORE,
											message = atts["message"]?.value,
											excType = atts["typr"]?.value
									)
									"property" -> {}
								}
							}
							is Characters ->
								case = case?.copy(trace = event.data)
							is EndElement ->
								when(event.name.localPart) {
									"testcase" -> suite = suite?.copy(
											cases = suite!!.cases + case!!
									)
								}
						}
					}
				}
				suite
			}

fun findCucumberResults(directory: File) : List<CucumberReport> = TODO()

fun findJmhResults(directory: File) : List<JmhBenchmarkResult> = TODO()

fun findGatlingResults(directory: File) : List<JmhBenchmarkResult> = TODO()
