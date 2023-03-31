package com.example.rocnikovaprace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_finance_jednoduche.*

class financeJednoduche : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finance_jednoduche)

        val financeJednoducheButton = findViewById<Button>(R.id.zpet)
        financeJednoducheButton.setOnClickListener {
            val intent = Intent(this, finance::class.java)
            startActivity(intent)
        }


        val vypocitatVysledekTlacitko= findViewById<Button>(R.id.vypocitatVysledek)
        val kapital = findViewById<EditText>(R.id.kapital)
        val sazba = findViewById<EditText>(R.id.sazba)
        val pocetRoku = findViewById<EditText>(R.id.pocetRoku)
        val vysledekJednoducheUroceniFull = findViewById<TextView>(R.id.vysledekJednoducheUroceni)
        val vysledekJednoducheUroceniClean = findViewById<TextView>(R.id.vysledekJednoducheUroceni2)

        vypocitatVysledekTlacitko.setOnClickListener {
            validace(kapital.text.toString(), sazba.text.toString(), pocetRoku.text.toString())
        }
    }

    //TADY JSEM MEL PROBLEM S TIM ZE JSEM VOLAL ISEMPTY PRO VAL KAPITAL A NE PRO PARAMETR KAPITAL
    fun validace(kapitalP: String, sazbaP: String,pocetRokuP: String) {
        val kapital = findViewById<EditText>(R.id.kapital)
        val sazba = findViewById<EditText>(R.id.sazba)
        val pocetRoku = findViewById<EditText>(R.id.pocetRoku)
        val vypocitatVysledek = findViewById<TextView>(R.id.vypocitatVysledek)
        if (kapitalP.isEmpty()) {
            kapital.error = "zadejte počáteční kapitál!"
        }
        if (sazbaP.isEmpty()) {
            sazba.error = "zadejte úrokovou sazbu!"
        }
        if (pocetRokuP.isEmpty()) {
            pocetRoku.error = "zadejte úrokovou sazbu!"
        }
        if (kapitalP.isNotEmpty() && sazbaP.isNotEmpty() && pocetRokuP.isNotEmpty()) {
            kalkulace(kapitalP.toDouble(), sazbaP.toDouble(), pocetRokuP.toDouble())
        }
    }
    fun kalkulace(kapitalP: Double, sazbaP: Double, pocetRokuP: Double) {
        val vysledekJednoducheUroceniFull = findViewById<TextView>(R.id.vysledekJednoducheUroceni)
        val vysledekJednoducheUroceniClean = findViewById<TextView>(R.id.vysledekJednoducheUroceni2)
        var resultFull = 0.0
        var resultClean = 0.0
        resultFull = ((kapitalP * (sazbaP/100))*pocetRokuP)+kapitalP
        resultClean = (kapitalP * (sazbaP/100))*pocetRokuP
            vysledekJednoducheUroceniFull.text = resultFull.toString()
            vysledekJednoducheUroceniClean.text =resultClean.toString()
    }
}
