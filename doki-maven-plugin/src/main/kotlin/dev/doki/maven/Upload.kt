package dev.doki.maven

import dev.doki.api.ProjectDataResource
import dev.doki.cli.client.restResource
import java.io.File
import java.util.UUID

inline fun <reified R, reified T : ProjectDataResource<R>> File.submitReports(dokiServerUrl : String, projectUUID: UUID, projectToken : String, collect : (File) -> List<R>) {
	val results = collect(this)
	val resource : T = restResource(dokiServerUrl)
	resource.submitReports(
			projectId = projectUUID,
			token = projectToken,
			reports = results
	)
}
