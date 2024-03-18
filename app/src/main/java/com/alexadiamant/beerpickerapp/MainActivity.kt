package com.alexadiamant.beerpickerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findBeer = findViewById<Button>(R.id.b_find_beer)

        findBeer.setOnClickListener {
            val spinnerView = findViewById<Spinner>(R.id.sp_beers)
            val colorBeer = spinnerView.selectedItem.toString()

            val beerList = getBeerAdvise(colorBeer)

            val finBeer = beerList.reduce{ str, item -> str + '\n' + item }
            val typesBeer = findViewById<TextView>(R.id.tv_beer_types)
            typesBeer.text = finBeer
        }
    }
    fun getBeerAdvise(colorBeer: String): List<String> {
        return when (colorBeer) {
            "Light" -> listOf("Jail Pale Ale", "Lager Lite")
            "Amber" -> listOf("Jack Amber", "Red Moose")
            "Brown" -> listOf("Brown Bear Beer", "Bock Brownie")
            else -> listOf("Gout Stout", "Dark Daniel")
        }
    }
}