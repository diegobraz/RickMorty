package kanda.lab.domain

import kanda.lab.domain.remote.DefaultNetworkManager
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance

object DomainDI {
    operator fun invoke() = DI.Module(name = "platform-domain-di") {

        bindSingleton {
            DefaultNetworkManager(connectionCheck = instance())
        }
    }
}
