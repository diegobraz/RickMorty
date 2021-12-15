package kanda.lab.network.client

import kotlinx.serialization.json.Json

object Json {
    val relaxed by lazy {
        Json {
            allowSpecialFloatingPointValues = true
            encodeDefaults = true
            ignoreUnknownKeys = true
            isLenient = true
            useArrayPolymorphism = true
        }
    }
}
