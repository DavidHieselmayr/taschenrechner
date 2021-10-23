package at.htl.leonding.taschenrechner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberAction(view: android.view.View) {}
    fun operatorAction(view: android.view.View) {}
    fun allClearAction(view: android.view.View) {}
    fun backspaceAction(view: android.view.View) {}
    fun equalAction(view: android.view.View) {}
}