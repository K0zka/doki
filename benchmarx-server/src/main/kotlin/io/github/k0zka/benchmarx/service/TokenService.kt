package io.github.k0zka.benchmarx.service

import io.github.k0zka.benchmarx.model.project.Token
import java.util.UUID

interface TokenService {

	fun listByProject(projectId: UUID) : List<Token>
	fun generateToken(projectId: UUID) : Token
	fun checkToken(projectId: UUID, token : String)
	fun removeToken(projectId: UUID, token : String)

}