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

        val editN = findViewById<EditText>(R.id.editTextN)
        val editK = findViewById<EditText>(R.id.editTextK)
        val buttonCombination= findViewById<Button>(R.id.buttonCombinations)
        val buttonVariation = findViewById<Button>(R.id.buttonVariations)
        val buttonPermutation = findViewById<Button>(R.id.buttonPermutations)
        val textResult = findViewById<TextView>(R.id.textViewResult)

        buttonCombination.setOnClickListener {
            val n = editN.text.toString().toInt()
            val k = editK.text.toString().toInt()
            val result = combination(n, k)
            textResult.text = "Kombinace: $result"
        }

        buttonVariation.setOnClickListener {
            val n = editN.text.toString().toInt()
            val k = editK.text.toString().toInt()
            val result = variation(n, k)
            textResult.text = "Variace: $result"
        }

        buttonPermutation.setOnClickListener {
            val n = editN.text.toString().toInt()
            val k = editK.text.toString().toInt()
            val result = permutation(n, k)
            textResult.text = "Permutace: $result"
        }
    }

    private fun combination(n: Int, k: Int): Int {
        if (n < k) {
            return 0
        }
        return factorial(n) / (factorial(k) * factorial(n - k))
    }

    private fun variation(n: Int, k: Int): Int {
        if (n < k) {
            return 0
        }
        return factorial(n) / factorial(n - k)
    }

    private fun permutation(n: Int, k: Int): Int {
        if (n < k) {
            return 0
        }
        return factorial(n) / factorial(n - k)
    }

    private fun factorial(num: Int): Int {
        if (num == 0) {
            return 1
        }
        var result = 1
        for (i in 1..num) {
            result *= i
        }
        return result
    }
}


