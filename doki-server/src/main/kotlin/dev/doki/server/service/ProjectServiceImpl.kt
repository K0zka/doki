package dev.doki.server.service

import com.mongodb.client.MongoClient
import dev.doki.model.project.Project
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

	override fun delete(projectId: UUID) {
		mongoClient.project.deleteOne(
				Document( "_id", projectId )
		)
	}

}