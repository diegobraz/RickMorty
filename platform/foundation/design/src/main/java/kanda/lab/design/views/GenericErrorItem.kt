package kanda.lab.design.views

import android.view.View
import com.xwray.groupie.viewbinding.BindableItem
import kanda.lab.design.R
import kanda.lab.design.databinding.ErrorItemBinding

class GenericErrorItem(private val retry: () -> Unit) : BindableItem<ErrorItemBinding>() {

    override fun bind(viewBinding: ErrorItemBinding, position: Int) {
        viewBinding.tryAgainBtn.setOnClickListener {
            retry.invoke()
        }
    }

    override fun getLayout(): Int = R.layout.error_item

    override fun initializeViewBinding(view: View): ErrorItemBinding =
        ErrorItemBinding.bind(view)
}
