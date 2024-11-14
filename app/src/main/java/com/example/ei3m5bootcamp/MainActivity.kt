package com.example.ei3m5bootcamp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // init los botones y el TextView
        val buttonShowProfile: MaterialButton = findViewById(R.id.buttonShowProfile)
        val buttonCalculate: MaterialButton = findViewById(R.id.buttonCalculate)
        val buttonAuction: MaterialButton = findViewById(R.id.buttonAuction)
        val textViewResult: TextView = findViewById(R.id.textViewResult)

        // init el TextView "by Jonny A. V."
        val textViewByJonny: TextView = findViewById(R.id.textViewByJonny)
        textViewByJonny.text = "by Jonny A. V."
        textViewByJonny.textSize = 8f // el tamaño del texto

        // creo los objetos Person (Amanda y Atiqah)
        val amanda = Person("Amanda", 33, "play tennis", null)
        val atiqah = Person("Atiqah", 28, "climb", amanda)

        // la accion para mostrar los perfiles
        buttonShowProfile.setOnClickListener {
            amanda.showProfile()
            atiqah.showProfile()
            textViewResult.text = """
                Name: Amanda
                Age: 33
                Likes to play tennis. Doesn't have a referrer.

                Name: Atiqah
                Age: 28
                Likes to climb. Has a referrer named Amanda, who likes to play tennis.
            """.trimIndent()
        }

        // la accion para realizar el cálculo de la suma y el promedio
        buttonCalculate.setOnClickListener {
            val resultado = calcularResultado()
            textViewResult.text = resultado
            Toast.makeText(this, "¡Cálculo realizado!", Toast.LENGTH_SHORT).show()
        }

        // esto es para mostrar el resultado de la subasta
        buttonAuction.setOnClickListener {
            // creo una oferta para el artículo
            val winningBid = Bid(5000)
            // muestro el precio de subasta en el TextView
            textViewResult.text = """
                Item A is sold at ${auctionPrice(winningBid, 2000)}.
                Item B is sold at ${auctionPrice(null, 3000)}.
            """.trimIndent()
        }
    }

    private fun calcularResultado(): String {
        val num1 = 10
        val num2 = 33
        val num3 = 66

        var resultado = num1 + num2 + num3

        val num1Modificado = 55
        resultado = num1Modificado + num2 + num3

        val promedio = (num1 + num2 + num3) / 3

        return "La nueva suma es: $resultado\nEl promedio es: $promedio"
    }

    // una fun para auctionPrice que decide el precio según si hay una oferta
    fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
        return bid?.amount ?: minimumPrice
    }
}

// uso la clase Person para representar a una persona y su perfil
class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        val referrerInfo = referrer?.let {
            "Has a referrer named ${it.name}, who likes to ${it.hobby}."
        } ?: "Doesn't have a referrer."

        println("""
            Name: $name
            Age: $age
            Likes to $hobby. $referrerInfo
        """.trimIndent())
    }
}

// aca pongo un Bid para representar una oferta en la subasta
class Bid(val amount: Int)

