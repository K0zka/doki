package dev.doki.server.service

import com.mongodb.client.MongoClient
import dev.doki.model.project.Token
import io.github.kerubistan.kroki.random.genPassword
import io.github.kerubistan.kroki.time.now
import java.util.UUID
import java.util.UUID.randomUUID
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class TokenServiceImpl : TokenService {

	@Inject
	lateinit var mongoClient: MongoClient

	override fun listByProject(projectId: UUID): List<Token> =
			mongoClient.token.listBy(Token::projectId.name, projectId.toString())

	override fun generateToken(projectId: UUID): Token = Token(
			token = genPassword(length = 64),
			id = randomUUID(),
			generated = now(),
			projectId = projectId
	).apply { mongoClient.token.insert(this) }

	override fun checkToken(projectId: UUID, token: String) {
		check(mongoClient.token.listBy<Token>(
				mapOf(
						Token::projectId.name to projectId.toString(),
						Token::token.name to token
				)
		).isNotEmpty())
	}

	override fun removeToken(projectId: UUID, token: String) {
		mongoClient.token.deleteBy(
				mapOf(
						Token::projectId.name to projectId.toString(),
						Token::token.name to token
				)
		)
	}

}
