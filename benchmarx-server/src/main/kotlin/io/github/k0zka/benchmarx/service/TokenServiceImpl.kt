package io.github.k0zka.benchmarx.service

import com.mongodb.client.MongoClient
import io.github.k0zka.benchmarx.model.project.Token
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
			mongoClient.tokenCollection.listBy(Token::projectId.name, projectId.toString())

	override fun generateToken(projectId: UUID): Token {
		val token = Token(
				token = genPassword(length = 64),
				id = randomUUID(),
				generated = now(),
				projectId = projectId
		)
		mongoClient.tokenCollection.insert(token)
		return token
	}

}
