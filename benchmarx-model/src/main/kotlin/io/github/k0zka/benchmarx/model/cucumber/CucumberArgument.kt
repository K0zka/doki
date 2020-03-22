package io.github.k0zka.benchmarx.model.cucumber

import com.fasterxml.jackson.annotation.JsonProperty

data class CucumberArgument(@JsonProperty("val") val value : Any?, val offset: Int?)
