package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var textView: TextView
    private lateinit var linearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.removeButton)
        textView = findViewById(R.id.titleTextView)
        linearLayout = findViewById(R.id.rootLayout)

        button.setOnClickListener {
            linearLayout.removeView(textView)
            button.isEnabled = false
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val removedTextView = linearLayout.childCount == 1
        val isEnabledButton = button.isEnabled
        outState.putBoolean(KEY_TEXT_VIEW, removedTextView)
        outState.putBoolean(KEY_BUTTON, isEnabledButton)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState.getBoolean(KEY_TEXT_VIEW)) {
            linearLayout.removeView(textView)
        }
        button.isEnabled = savedInstanceState.getBoolean(KEY_BUTTON)
    }

    companion object {
        const val KEY_TEXT_VIEW = "keyt"
        const val KEY_BUTTON = "keyb"
    }
}