package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val count = Count.Base(2)

    private lateinit var button: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.incrementButton)
        textView = findViewById(R.id.countTextView)

        button.setOnClickListener {
            val result = count.increment(textView.text.toString())
            textView.text = result
        }
    }
}