package kanda.lab.network

import kanda.lab.domain.injection.InjectionTags
import kanda.lab.network.client.BuildRetrofit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.bindSingleton
import org.kodein.di.instance

object NetworkingDI {
    operator fun invoke() = DI.Module(name = "public-networking-di") {

        bindProvider {
            BuildRetrofit(
                apiURL = instance(InjectionTags.BASE_URL),
                httpClient = instance()
            )
        }

        bindSingleton {
            val interceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
        }
    }
}
