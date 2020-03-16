package io.github.k0zka.benchmarx.maven

import org.apache.maven.plugin.AbstractMojo
import org.apache.maven.plugins.annotations.LifecyclePhase
import org.apache.maven.plugins.annotations.Mojo
import org.apache.maven.plugins.annotations.Parameter
import java.io.File

@Mojo(name = "upload", defaultPhase = LifecyclePhase.DEPLOY, requiresProject = false, requiresOnline = true)
class BenchmarxUploadMojo : AbstractMojo() {

	@Parameter
	internal var jmhResults : File? = null

	@Parameter
	internal var cucumberResults : File? = null

	@Parameter(defaultValue = "target/surefire-reports")
	internal var junitResults : File? = null

	override fun execute() {
		TODO("not implemented")
	}
}