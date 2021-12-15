package kanda.lab.myapplication

import android.app.Application
import android.content.Context
import kanda.lab.domain.injection.InjectionTags
import org.kodein.di.DIAware
import org.kodein.di.bindProvider
import org.kodein.di.conf.ConfigurableDI

class BootstrapApplication : Application(), DIAware {

    override val di = ConfigurableDI(mutable = true).apply {

        modules.forEach {
            addImport(it)
        }

        addConfig {
            bindProvider<Context> { this@BootstrapApplication }
            bindProvider(tag = InjectionTags.BASE_URL) { "https://api.blockchain.info/" }
        }
    }
}
