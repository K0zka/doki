package io.github.k0zka.benchmarx.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.mongodb.BasicDBObject
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import io.github.k0zka.benchmarx.quarkus.RegisterCustomModuleCustomizer
import org.bson.Document

val objectMapper = ObjectMapper().apply {
	RegisterCustomModuleCustomizer().customize(this)
}

val MongoClient.database: MongoDatabase get() = this.getDatabase("benchmarx")

val MongoClient.projectCollection: MongoCollection<Document> get() = this.database.getCollection("projects")

val MongoClient.tokenCollection: MongoCollection<Document> get() = this.database.getCollection("projects")

inline fun <reified T> MongoCollection<Document>.getById(id: String) =
		read<T>(this.find(BasicDBObject("_id", id)).single())

inline fun <reified T> MongoCollection<Document>.listBy(property: String, value: String) =
		this.find(BasicDBObject(property, value)).map { read<T>(it) }.toList()

fun <T> MongoCollection<Document>.insert(entity: T) =
		insertOne(Document.parse(objectMapper.writeValueAsString(entity)))

inline fun <reified T> read(doc: Document) =
		objectMapper.readValue<T>(doc.toJson(), T::class.java)
