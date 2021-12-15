package kanda.lab.android.connection

import android.content.Context
import android.net.ConnectivityManager
import androidx.lifecycle.ViewModelProvider
import kanda.lab.domain.remote.ConnectionCheck
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.bindSingleton
import org.kodein.di.instance

object CommonDI {
    operator fun invoke() = DI.Module(name = "public-android-di") {

        bindProvider {
            val context: Context = instance()

            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        }

        bindSingleton<ConnectionCheck> {
            ConnectionManager(cm = instance())
        }

        bindSingleton<ViewModelProvider.Factory> { ViewModelFactory(di) }
    }
}
