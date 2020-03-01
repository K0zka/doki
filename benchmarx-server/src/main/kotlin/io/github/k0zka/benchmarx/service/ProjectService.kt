package io.github.k0zka.benchmarx.service

import io.github.k0zka.benchmarx.model.project.Project
import java.util.UUID

interface ProjectService {

	fun getById(id : UUID) : Project

	fun list() : List<Project>

	fun create(project: Project)

}