package dev.doki.cli.client

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget
import javax.ws.rs.client.Client
import javax.ws.rs.client.ClientBuilder

val client: Client by lazy {
	ClientBuilder.newClient()
}

inline fun <reified T> restResource(serverUrl : String) : T {
	val target = client.target(serverUrl) as ResteasyWebTarget
	return target.proxy(T::class.java)
}
