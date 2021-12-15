package kanda.lab.fake

import kanda.lab.domain.remote.ConnectionCheck

object ConnectionCheckFake : ConnectionCheck {
    var hasConnection = true
    fun reset() {
        hasConnection = true
    }

    override fun hasConnection(): Boolean {
        return hasConnection
    }
}
