package kanda.lab.myapplication

import kanda.lab.android.connection.CommonDI
import kanda.lab.domain.DomainDI
import kanda.lab.network.NetworkingDI

internal val modules = listOf(
    NetworkingDI(),
    CommonDI(),
    DomainDI()
)
