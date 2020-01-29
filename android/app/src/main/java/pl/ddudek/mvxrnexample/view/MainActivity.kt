package pl.ddudek.mvxrnexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {

//    lateinit var view: MainMvcView
    lateinit var view: MainRNMvcView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        view = MainMvcView(layoutInflater, null)
        view = MainRNMvcView(this, null)
        setContentView(view.getRootView())
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        view.start(MainRNMvcView.ViewState("...", "...", true))
        view.bindViewState(MainRNMvcView.ViewState("...", "...", true))
        Handler().postDelayed({
            view.bindViewState(MainRNMvcView.ViewState("A title", "A subtitle", false))
        }, 4000)

        super.onPostCreate(savedInstanceState)
    }

    override fun onDestroy() {
        view.destroy()
        super.onDestroy()
    }
}
