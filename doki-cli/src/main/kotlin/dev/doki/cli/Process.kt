package dev.doki.cli

import com.fasterxml.aalto.stax.InputFactoryImpl
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import dev.doki.api.ProjectDataResource
import dev.doki.cli.client.restResource
import dev.doki.model.cucumber.CucumberFeature
import dev.doki.model.jmh.JmhBenchmarkResult
import dev.doki.model.junit.JunitTestCase
import dev.doki.model.junit.JunitTestSuite
import dev.doki.model.junit.Outcome
import io.github.kerubistan.kroki.collections.concat
import io.github.kerubistan.kroki.iteration.toList
import java.io.File
import java.util.UUID
import javax.xml.stream.events.Attribute
import javax.xml.stream.events.Characters
import javax.xml.stream.events.EndElement
import javax.xml.stream.events.StartElement

private val xmlInputFactory by lazy {
	InputFactoryImpl().apply {
		configureForSpeed()
	}
}

private val jsonObjectMapper by lazy {
	ObjectMapper().registerModule(KotlinModule())
			.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)
}

fun File.listFilesEndingWith(suffix: String): List<File> = this
		.listFiles { _, name -> name.endsWith(suffix) }?.toList()?.filterNotNull() ?: listOf()

fun findJunitResults(directory: File): List<JunitTestSuite> = directory
		.listFilesEndingWith(".xml")
		.mapNotNull {
			var suite: JunitTestSuite? = null
			var case: JunitTestCase? = null
			xmlInputFactory.createXMLEventReader(it).let { reader ->
				reader.forEach { event ->
					when (event) {
						is StartElement -> {
							val atts = event.attributes.toList().filterIsInstance<Attribute>().associateBy {
								it.name.localPart
							}
							when (event.name.localPart) {
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
								"property" -> {
								}
							}
						}
						is Characters ->
							case = case?.copy(trace = event.data)
						is EndElement ->
							when (event.name.localPart) {
								"testcase" -> suite = suite?.copy(
										cases = suite!!.cases + case!!
								)
							}
					}
				}
			}
			suite
		}

fun findCucumberResults(directory: File): List<CucumberFeature> = directory
		.listFilesEndingWith(".json")
		.map { cucumberReportFile ->
			jsonObjectMapper.readValue<List<CucumberFeature>>(cucumberReportFile)
		}.concat()

fun findJmhResults(directory: File): List<JmhBenchmarkResult> =
		directory.listFilesEndingWith(".json").map { jmhReportFile ->
			jsonObjectMapper.readValue<List<JmhBenchmarkResult>>(jmhReportFile)
		}.concat()

fun findGatlingResults(directory: File): List<JmhBenchmarkResult> = TODO()

inline fun <reified R, reified T : ProjectDataResource<R>> File.submitReports(dokiServerUrl : String, projectUUID: UUID, projectToken : String, collect : (File) -> List<R>) {
	val results = collect(this)
	val resource : T = restResource(dokiServerUrl)
	resource.submitReports(
			projectId = projectUUID,
			token = projectToken,
			reports = results
	)
}
