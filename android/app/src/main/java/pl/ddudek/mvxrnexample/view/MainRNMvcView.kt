package pl.ddudek.mvxrnexample.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.facebook.react.ReactApplication
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactRootView

class MainRNMvcView (val context: Context, parent: ViewGroup?) {

    private val view = ReactRootView(context)

    fun start(state: ViewState) {
        val initialProperties = bundleState(state)
        view.startReactApplication(getReactNativeHost()?.reactInstanceManager, "MainMvxView", initialProperties)
    }

    private fun bundleState(state: ViewState): Bundle {
        return Bundle().apply {
            putString("title", state.title)
            putString("subtitle", state.subtitle)
            putBoolean("loading", state.loading)
        }
    }

    fun getRootView(): View {
        return view
    }

    fun bindViewState(state: ViewState) {
        view.setAppProperties(state.let { bundleState(it) })
    }

    protected fun getReactNativeHost(): ReactNativeHost? {
        return (context.applicationContext as ReactApplication).reactNativeHost
    }

    fun destroy() {
        view.unmountReactApplication()
    }

    data class ViewState (
            val title: String,
            val subtitle: String,
            val loading: Boolean
    )
}
