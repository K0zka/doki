package dev.doki.api

import java.util.UUID

interface ProjectDataResource<T> {
	fun submitReports(
			projectId: UUID,
			token: String,
			reports: List<T>
	): String
}