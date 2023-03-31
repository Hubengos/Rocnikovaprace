package com.example.rocnikovaprace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

class kombinatorika : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kombinatorika)
        val kombinatorikaButton = findViewById<Button>(R.id.zpet)
        kombinatorikaButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val editN = findViewById<EditText>(R.id.editTextN)
        val editK = findViewById<EditText>(R.id.editTextK)
        val buttonCombination= findViewById<Button>(R.id.buttonCombinations)
        val buttonVariation = findViewById<Button>(R.id.buttonVariations)
        val buttonPermutation = findViewById<Button>(R.id.buttonPermutations)
        val textResult = findViewById<TextView>(R.id.textViewResult)

        buttonCombination.setOnClickListener {
            val n = editN.text.toString().toInt()
            val k = editK.text.toString().toInt()
            val resultBezOpakovani = combination(n, k)
            val resultSOpakovanim = combinationRep(n, k)
            textResult.text = "Kombinace bez opakování: $resultBezOpakovani s opakováním: $resultSOpakovanim"
        }

        buttonVariation.setOnClickListener {
            val n = editN.text.toString().toInt()
            val k = editK.text.toString().toInt()
            val resultBezOpakovani = variation(n, k)
            val resultSOpakovanim = variationRep(n, k)
            textResult.text = "Variace bez opakování: $resultBezOpakovani s opakováním: $resultSOpakovanim"
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

    private fun combinationRep(n: Int, k: Int): Int {
        return factorial(n + k - 1) / (factorial(k) * factorial(n - 1))
    }
    private fun variationRep(n: Int, k: Int): Int {
        return n.toDouble().pow(k).toInt()
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


