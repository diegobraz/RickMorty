package kanda.lab.myapplication

import android.app.Application
import android.content.Context

import dagger.hilt.android.HiltAndroidApp
import kanda.lab.domain.injection.InjectionTags
import org.kodein.di.DIAware
import org.kodein.di.bindProvider
import org.kodein.di.conf.ConfigurableDI

@HiltAndroidApp
class BootstrapApplication : Application() {}