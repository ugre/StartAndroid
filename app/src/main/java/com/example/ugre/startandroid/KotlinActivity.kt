package com.example.ugre.startandroid

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class KotlinActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        findViewById<Button>(R.id.btnClickMe).setOnClickListener {
            Toast.makeText(this, "Hello, this is written in Kotlin", Toast.LENGTH_LONG).show()
        }
    }
}
