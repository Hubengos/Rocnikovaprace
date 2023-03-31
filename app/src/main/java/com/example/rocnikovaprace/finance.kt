package com.example.rocnikovaprace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import com.google.android.material.textfield.TextInputEditText

class finance : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.finance)
    //tlačítko zpět
        val financeButtonZpet = findViewById<Button>(R.id.zpet)
        financeButtonZpet.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val financeJednoducheUroceniTlacitko = findViewById<Button>(R.id.jednoduche)
        financeJednoducheUroceniTlacitko.setOnClickListener {
            val intent = Intent(this, financeJednoduche::class.java)
            startActivity(intent)
        }
        val financeSlozeneUroceniTlacitko = findViewById<Button>(R.id.slozene)
        financeSlozeneUroceniTlacitko.setOnClickListener {
            val intent = Intent(this, financeSlozene::class.java)
            startActivity(intent)
        }
    }
}


