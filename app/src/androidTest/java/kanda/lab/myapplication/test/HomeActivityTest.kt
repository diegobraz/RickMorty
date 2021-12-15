package kanda.lab.myapplication.test

import androidx.test.ext.junit.runners.AndroidJUnit4
import kanda.lab.domain.remote.ConnectionCheck
import kanda.lab.fake.ConnectionCheckFake
import org.junit.Before
import org.junit.runner.RunWith
import org.kodein.di.bindProvider

@RunWith(AndroidJUnit4::class)
class HomeActivityTest {

    @Before
    fun before_each_test() {

        dependenciesOverride {
            bindProvider<ConnectionCheck>(overrides = true) { ConnectionCheckFake }
        }

        ConnectionCheckFake.reset()
    }
}
