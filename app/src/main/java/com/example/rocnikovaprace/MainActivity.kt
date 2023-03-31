package com.example.rocnikovaprace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val financeTlacitko = findViewById<Button>(R.id.financniMatematika)
        financeTlacitko.setOnClickListener {
            val intent = Intent(this, finance::class.java)
            startActivity(intent)
        }
        val kombinatorikaTlacitko = findViewById<Button>(R.id.kombinatorikaTlacitko)
        kombinatorikaTlacitko.setOnClickListener {
            val intent = Intent(this, kombinatorika::class.java)
            startActivity(intent)
        }
        val posloupnostiTlacitko = findViewById<Button>(R.id.posloupnosti)
        posloupnostiTlacitko.setOnClickListener {
            val intent = Intent(this, Posloupnosti::class.java)
            startActivity(intent)
        }
    }
}