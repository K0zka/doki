package dev.doki.cli

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.required
import com.github.ajalt.mordant.TermColors

object BenchmarxCli : CliktCommand(name = "benchmarx") {

	private val serverUrl by option(help = "server url", envvar = "server-url").default("http://localhost/")
	private val token by option(help = "token", envvar = "token").required()

	override fun run() {
		val colors = TermColors()

		println(colors.green("server url: $serverUrl"))
	}

}

fun main(vararg params : String) = BenchmarxCli.main(params)