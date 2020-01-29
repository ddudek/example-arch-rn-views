package pl.ddudek.mvxrnexample.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import pl.ddudek.mvxrnexample.R
import pl.ddudek.mvxrnexample.databinding.ActivityMainBinding

class MainMvcView (layoutInflater: LayoutInflater, parent: ViewGroup?) {

    private val viewBinding: ActivityMainBinding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_main, parent, false)

    fun getRootView(): View {
        return viewBinding.root
    }

    fun bindViewState(state: ViewState) {
        viewBinding.state = state
    }

    data class ViewState (
            val title: String,
            val subtitle: String,
            val loading: Boolean
    )
}
