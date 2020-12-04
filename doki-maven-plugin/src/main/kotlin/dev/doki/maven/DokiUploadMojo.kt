package dev.doki.maven

import dev.doki.api.JUnitResource
import dev.doki.api.JmhResource
import dev.doki.cli.findJmhResults
import dev.doki.cli.findJunitResults
import dev.doki.model.jmh.JmhBenchmarkResult
import dev.doki.model.junit.JunitTestSuite
import io.github.kerubistan.kroki.strings.toUUID
import org.apache.maven.plugin.AbstractMojo
import org.apache.maven.plugins.annotations.LifecyclePhase
import org.apache.maven.plugins.annotations.Mojo
import org.apache.maven.plugins.annotations.Parameter
import java.io.File

@Mojo(name = "upload", defaultPhase = LifecyclePhase.DEPLOY, requiresProject = false, requiresOnline = true)
class DokiUploadMojo : AbstractMojo() {

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

		junitResults
				?.submitReports<JunitTestSuite, JUnitResource>(dokiServerUrl, projectUUID, token, ::findJunitResults)
		jmhResults?.submitReports<JmhBenchmarkResult, JmhResource>(dokiServerUrl, projectUUID, token, ::findJmhResults)
		// and so on...

	}
}