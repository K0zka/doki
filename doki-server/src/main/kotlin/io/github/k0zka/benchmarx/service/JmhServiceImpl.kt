package io.github.k0zka.benchmarx.service

import com.mongodb.client.MongoClient
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class JmhServiceImpl : JmhService {
	@Inject
	lateinit var client: MongoClient
}