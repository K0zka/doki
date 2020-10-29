package dev.doki.server.service

import dev.doki.model.project.Project
import java.util.UUID

interface ProjectService {

	fun getById(id: UUID): Project

	fun list(): List<Project>

	fun create(project: Project)

}