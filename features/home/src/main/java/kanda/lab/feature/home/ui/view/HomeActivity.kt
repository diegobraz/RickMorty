package kanda.lab.feature.home.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kanda.lab.feature.home.ui.databinding.ActivityMainBinding
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI

class HomeActivity : AppCompatActivity(), DIAware {
    override val di: DI by closestDI()

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
