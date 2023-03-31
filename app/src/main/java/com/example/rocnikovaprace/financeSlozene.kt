package com.example.rocnikovaprace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.roundToInt

class financeSlozene : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finance_jednoduche)

        val financeSlozeneButton = findViewById<Button>(R.id.zpet)
        financeSlozeneButton.setOnClickListener {
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
        var SlozeneresultFull = 0.0
        var SlozeneresultClean = 0.0
        SlozeneresultFull = kapitalP * Math.pow(1 + sazbaP/100,pocetRokuP)
        SlozeneresultClean = kapitalP * Math.pow(1 + sazbaP/100,pocetRokuP)-kapitalP
        //dodelat zaokrouhleni
        var zaokrouhleneSlozeneresultFull = (SlozeneresultFull * 100.0).roundToInt() / 100.0
        var zaokrouhleneSlozeneresultClean = (SlozeneresultClean * 100.0).roundToInt() / 100.0
        vysledekJednoducheUroceniFull.text = zaokrouhleneSlozeneresultFull.toString()
        vysledekJednoducheUroceniClean.text = zaokrouhleneSlozeneresultClean.toString()
    }
}
