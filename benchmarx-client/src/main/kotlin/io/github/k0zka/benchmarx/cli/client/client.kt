package io.github.k0zka.benchmarx.cli.client

import io.github.k0zka.benchmarx.api.ProjectDataResource
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget
import javax.ws.rs.client.Client
import javax.ws.rs.client.ClientBuilder

val client: Client by lazy {
	ClientBuilder.newClient()
}

inline fun <reified T : ProjectDataResource<out Any>> projectResource(serverUrl : String) : T {
	val target = client.target(serverUrl) as ResteasyWebTarget
	return target.proxy(T::class.java)
}