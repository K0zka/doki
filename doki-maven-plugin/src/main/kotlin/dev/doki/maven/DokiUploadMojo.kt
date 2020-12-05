package dev.doki.maven

import dev.doki.api.JUnitResource
import dev.doki.api.JmhResource
import dev.doki.api.ProjectResource
import dev.doki.cli.client.restResource
import dev.doki.cli.findJmhResults
import dev.doki.cli.findJunitResults
import dev.doki.cli.submitReports
import dev.doki.model.jmh.JmhBenchmarkResult
import dev.doki.model.junit.JunitTestSuite
import io.github.kerubistan.kroki.strings.toUUID
import org.apache.maven.plugin.AbstractMojo
import org.apache.maven.plugins.annotations.LifecyclePhase
import org.apache.maven.plugins.annotations.Mojo
import org.apache.maven.plugins.annotations.Parameter
import java.io.File
import java.util.logging.Logger
import kotlin.reflect.jvm.jvmName

@Mojo(name = "upload", defaultPhase = LifecyclePhase.DEPLOY, requiresProject = false, requiresOnline = true)
class DokiUploadMojo : AbstractMojo() {

	companion object {
		private val logger = Logger.getLogger(DokiUploadMojo::class.jvmName)
	}

	@Parameter(defaultValue = "https://doki.dev/")
	internal var dokiServerUrl: String = "https://doki.dev/"

	@Parameter(name = "dokiProjectId")
	internal var projectId: String? = null

	@Parameter(name = "dokiToken")
	internal var dokiToken: String? = null

	@Parameter
	internal var jmhResults: File? = null

	@Parameter
	internal var cucumberResults: File? = null

	@Parameter(defaultValue = "target/surefire-reports")
	internal var junitResults: File? = null

	@Parameter(defaultValue = "target/gatling")
	internal var gatlingResults: File? = null

	override fun execute() {
		val projectUUID = requireNotNull(projectId) { "projectId is required" }.toUUID()
		val token = requireNotNull(dokiToken) { "dokiToken is required" }

		val project = restResource<ProjectResource>(dokiServerUrl).get(projectUUID)
		logger.info("""
			|project info: 
			|	- id: ${project.id}
			|	- name: ${project.name}
			|	- url: ${project.url}
		""".trimMargin())

		junitResults
				?.submitReports<JunitTestSuite, JUnitResource>(dokiServerUrl, projectUUID, token, ::findJunitResults)
		jmhResults?.submitReports<JmhBenchmarkResult, JmhResource>(dokiServerUrl, projectUUID, token, ::findJmhResults)
		// and so on...

	}
}