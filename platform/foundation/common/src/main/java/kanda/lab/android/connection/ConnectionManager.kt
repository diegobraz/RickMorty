package kanda.lab.android.connection

import android.net.ConnectivityManager
import android.net.NetworkCapabilities.TRANSPORT_CELLULAR
import android.net.NetworkCapabilities.TRANSPORT_WIFI
import kanda.lab.domain.remote.ConnectionCheck

class ConnectionManager(private val cm: ConnectivityManager) : ConnectionCheck {

    override fun hasConnection(): Boolean {

        val network = cm.activeNetwork ?: return false
        val capabilities = cm.getNetworkCapabilities(network) ?: return false
        return capabilities.run {
            hasTransport(TRANSPORT_CELLULAR) || hasTransport(TRANSPORT_WIFI)
        }
    }
}
