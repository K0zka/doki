package dev.doki.server.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.mongodb.BasicDBObject
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import dev.doki.server.quarkus.RegisterCustomModuleCustomizer
import org.bson.Document

val objectMapper = ObjectMapper().apply {
	RegisterCustomModuleCustomizer.customize(this)
}

val MongoClient.database: MongoDatabase get() = this.getDatabase("doki")

val MongoClient.project: MongoCollection<Document> get() = this.database.getCollection("projects")

val MongoClient.token: MongoCollection<Document> get() = this.database.getCollection("tokens")

val MongoClient.jmh: MongoCollection<Document> get() = this.database.getCollection("jmh")

val MongoClient.cucumber: MongoCollection<Document> get() = this.database.getCollection("cucumber")

val MongoClient.junit: MongoCollection<Document> get() = this.database.getCollection("junit")

inline fun <reified T> MongoCollection<Document>.getById(id: String) =
		read<T>(this.find(BasicDBObject("_id", id)).singleOrNull() ?: throw IllegalArgumentException("Entity by id $id does not exist"))

inline fun <reified T> MongoCollection<Document>.listBy(property: String, value: String) =
		this.find(BasicDBObject(property, value)).map { read<T>(it) }.toList()

inline fun <reified T> MongoCollection<Document>.listBy(properties: Map<String, String>) =
		this.find(BasicDBObject(properties)).map { read<T>(it) }.toList()

inline fun MongoCollection<Document>.deleteBy(properties: Map<String, String>) =
		this.deleteOne(BasicDBObject(properties))

fun <T> MongoCollection<Document>.insert(entity: T) =
		insertOne(Document.parse(objectMapper.writeValueAsString(entity)))

inline fun <reified T> read(doc: Document) =
		objectMapper.readValue<T>(doc.toJson(), T::class.java)
