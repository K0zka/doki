package io.github.k0zka.benchmarx.service

import com.mongodb.client.MongoClient
import io.github.k0zka.benchmarx.model.project.Project
import org.bson.Document
import java.util.UUID
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class ProjectServiceImpl : ProjectService {

	@Inject
	lateinit var mongoClient: MongoClient

	override fun getById(id: UUID): Project =
			mongoClient.project.getById(id.toString())

	override fun list(): List<Project> =
			mongoClient.project.find().map {
				read<Project>(it)
			}.toList()

	override fun create(project: Project) {
		mongoClient.project
				.insertOne(Document.parse(objectMapper.writeValueAsString(project)))
	}

}