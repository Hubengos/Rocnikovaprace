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

class temac1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temac1)

        val btnTemac1 = findViewById<Button>(R.id.zpet)
        btnTemac1.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        val btn = findViewById<Button>(R.id.btnpotvrdit)
        val cislo1 = findViewById<EditText>(R.id.cislo1)
        val cislo2 = findViewById<EditText>(R.id.cislo2)
        val vysledek = findViewById<TextView>(R.id.vysledek)

        btn.setOnClickListener{
            val soucet = (Integer.parseInt(cislo1.text.toString())+Integer.parseInt(cislo2.text.toString()))
            vysledek.setText(soucet)



        }



    }

}
