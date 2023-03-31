package com.example.rocnikovaprace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_posloupnosti.*

class Posloupnosti : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posloupnosti)
        val posloupnostiButton = findViewById<Button>(R.id.zpet)
        posloupnostiButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val editTextFirst = findViewById<EditText>(R.id.editTextFirst)
        val editTextDiff = findViewById<EditText>(R.id.editTextDiff)
        val editTextIndex = findViewById<EditText>(R.id.editTextIndex)
        val buttonNth = findViewById<Button>(R.id.buttonNth)
        val textViewNthResult = findViewById<TextView>(R.id.textViewNthResult)
        val editTextNumTerms = findViewById<EditText>(R.id.editTextNumTerms)
        val buttonSum = findViewById<Button>(R.id.buttonSum)
        val textViewSumResult = findViewById<TextView>(R.id.textViewSumResult)

        buttonNth.setOnClickListener {
            calculateNthTerm()
        }

        buttonSum.setOnClickListener {
            calculateSum()
        }

    }

private fun calculateNthTerm() {
    val first = editTextFirst.text.toString().toDouble()
    val diff = editTextDiff.text.toString().toDouble()
    val index = editTextIndex.text.toString().toInt()
    val nthTerm = first + (index - 1) * diff
    textViewNthResult.text = "N-tý člen: $nthTerm"
}

private fun calculateSum() {
    val first = editTextFirst.text.toString().toDouble()
    val diff = editTextDiff.text.toString().toDouble()
    val numTerms = editTextNumTerms.text.toString().toInt()
    val sum = numTerms * (2 * first + (numTerms - 1) * diff) / 2
    textViewSumResult.text ="Součet n členů: $sum"
}
}
