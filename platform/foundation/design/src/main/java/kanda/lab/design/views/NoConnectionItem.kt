package kanda.lab.design.views

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import kanda.lab.design.R
import kanda.lab.design.databinding.NoConnectionItemBinding

class NoConnectionItem(private val retry: () -> Unit) : BindableItem<NoConnectionItemBinding>() {

    override fun bind(viewBinding: NoConnectionItemBinding, position: Int) {
        viewBinding.connectionRetry.setOnClickListener {
            retry.invoke()
        }
    }

    override fun getLayout(): Int = R.layout.no_connection_item

    override fun initializeViewBinding(view: View): NoConnectionItemBinding =
        NoConnectionItemBinding.bind(view)
}
