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
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val plusmore = findViewById<Button>(R.id.plus)
        val minusmore = findViewById<Button>(R.id.minus)
        val delenomore = findViewById<Button>(R.id.deleno)
        val kratmore = findViewById<Button>(R.id.krat)
        val cislo1 = findViewById<EditText>(R.id.cislo1)
        val cislo2 = findViewById<EditText>(R.id.cislo2)
        val vysledek = findViewById<TextView>(R.id.vysledek)

        plusmore.setOnClickListener {
            validace(cislo1.text.toString(), cislo2.text.toString(), '+')
        }

        minusmore.setOnClickListener {
            validace(cislo1.text.toString(), cislo2.text.toString(), '-')
        }
        delenomore.setOnClickListener {
            validace(cislo1.text.toString(), cislo2.text.toString(), '/')
        }
        kratmore.setOnClickListener {
            validace(cislo1.text.toString(), cislo2.text.toString(), '*')
        }




    }

    fun validace(prvni: String, druhy: String, operator: Char) {
        val cislo1 = findViewById<EditText>(R.id.cislo1)
        val cislo2 = findViewById<EditText>(R.id.cislo2)
        val vysledek = findViewById<TextView>(R.id.vysledek)
        if (prvni.isEmpty()) {
            cislo1.error = "zadejte číslo!"
        }
        if (druhy.isEmpty()) {
            cislo2.error = "zadejte číslo!"
        }
        if (prvni.isNotEmpty() && druhy.isNotEmpty()) {
            calculation(prvni.toDouble(), druhy.toDouble(), operator)
        }
    }

    fun calculation(prvni: Double, druhy: Double, operator: Char) {
        val vysledek = findViewById<TextView>(R.id.vysledek)
        var result = 0.0
        when (operator) {
            '+' -> result = prvni + druhy
            '-' -> result = prvni - druhy
            '*' -> result = prvni * druhy
            '/' -> result = prvni / druhy
        }
        vysledek.text = result.toString()
    }
    }


