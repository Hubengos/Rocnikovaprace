package com.example.rocnikovaprace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnTemac1 = findViewById<Button>(R.id.temac1)
        btnTemac1.setOnClickListener {
            val intent = Intent(this,temac1::class.java)
            startActivity(intent)
        }
    }
}