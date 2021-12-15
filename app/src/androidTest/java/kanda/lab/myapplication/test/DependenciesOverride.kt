package kanda.lab.myapplication.test

import androidx.test.platform.app.InstrumentationRegistry
import kanda.lab.myapplication.BootstrapApplication
import org.kodein.di.DI

internal val app = InstrumentationRegistry
    .getInstrumentation()
    .targetContext
    .applicationContext as BootstrapApplication

fun dependenciesOverride(config: DI.MainBuilder.() -> Unit) {
    app.di.addConfig(config)
}
