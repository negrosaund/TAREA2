package com.example.tarea2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var Predic: EditText
    private lateinit var btnLanzar: Button
    private lateinit var Resultado: TextView
    private lateinit var dadoImagen: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Predic = findViewById(R.id.Predic)
        btnLanzar = findViewById(R.id.btnLanzar)
        Resultado = findViewById(R.id.Resultado)
        dadoImagen = findViewById(R.id.dado)

        btnLanzar.setOnClickListener {
            val prediccionTexto = Predic.text.toString()

            if (prediccionTexto.isEmpty()) {
                Toast.makeText(this, "Ingresa un número entre 1 y 6", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val prediccion = prediccionTexto.toIntOrNull()
            if (prediccion == null || prediccion < 1 || prediccion > 6) {
                Toast.makeText(this, "Número fuera de rango", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val resultadoDado = Random.nextInt(1, 7) // 1 al 6

            val imagenId = when (resultadoDado) {
                1 -> R.drawable.dado1
                2 -> R.drawable.dado2
                3 -> R.drawable.dado3
                4 -> R.drawable.dado4
                5 -> R.drawable.dado5
                6 -> R.drawable.dado6
                else -> R.drawable.dado0
            }
            dadoImagen.setImageResource(imagenId)

            if (prediccion == resultadoDado) {
                Resultado.text = "¡Ganaste! Salió $resultadoDado"
            } else {
                Resultado.text = "Intenta de nuevo. Salió $resultadoDado"
            }
        }
    }
}
