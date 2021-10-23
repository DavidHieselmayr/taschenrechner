package at.htl.leonding.taschenrechner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var canAddOperation = false
    private var canAddDecimal = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberAction(view: View) {
        if (view is Button) {
            if (view.text == ".") {
                if (canAddDecimal) {
                    workingsTV.append(view.text)
                }
                canAddDecimal = false
            } else {
                workingsTV.append(view.text)
            }
            canAddOperation = true
        }
    }

    fun operatorAction(view: android.view.View) {
        if (view is Button && canAddOperation) {
            workingsTV.append(view.text)
            canAddOperation = false
            canAddDecimal = true
        }

    }

    fun allClearAction(view: android.view.View) {
        workingsTV.text = ""
        resultsTV.text = ""
    }

    fun backspaceAction(view: android.view.View) {
        val length = workingsTV.length()
        if (length > 0) {
            workingsTV.text = workingsTV.text.subSequence(0, length - 1)
        }

    }

    fun equalAction(view: android.view.View) {
        resultsTV.text = calc()
    }

    private fun calc(): String {
        return ""
    }

    private fun digits(): MutableList<Any> {
        val list = mutableListOf<Any>()
        var currentDigit = ""

        for (char in workingsTV.text) {
            if (char.isDigit() || char == '.') {
                currentDigit += char
            } else {
                list.add(currentDigit.toFloat())
                currentDigit = ""
                list.add(char)
            }
        }

        if(currentDigit != ""){
            list.add(currentDigit.toFloat())
        }

        return list
    }
}