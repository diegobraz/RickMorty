package kanda.lab.android.connection

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.DIAware
import org.kodein.di.direct
import org.kodein.type.erased

inline fun <reified VM : ViewModel, T> T.viewModel(): Lazy<VM> where T : DIAware, T : FragmentActivity {
    return lazy { ViewModelProvider(this, direct.Instance(erased())).get(VM::class.java) }
}
