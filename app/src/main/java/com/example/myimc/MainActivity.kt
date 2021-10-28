package com.example.myimc

import android.content.res.ColorStateList
import android.icu.number.IntegerWidth
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCalcular:Button = Calcular
        val resultado:TextView = Resultado
        val resultado2 = Resultado2

        btCalcular.setOnClickListener {

            val peso = Peso.text.toString().toDouble()
            val altura = Altura.text.toString().toDouble()
            val conta = String.format("%.1f", peso/(altura*altura)).toDouble()


            if (conta < 18.5){
                resultado.setText("$conta")
                resultado.setTextColor(Color.BLUE)
                resultado2.setText("Peso baixo")


            }else if  (conta< 25){
                resultado.setText("$conta")
                resultado.setTextColor(Color.GREEN)
                resultado2.setText("Peso adequado")

            }else if (conta < 30){
                resultado.setText("$conta")
                resultado.setTextColor(Color.BLUE)
                resultado2.setText("Em sobrepeso")

            }else {
                resultado.setText("$conta")
                resultado.setTextColor(Color.RED)
                resultado2.setText("Em obesidade")

            }


        }
    }
}