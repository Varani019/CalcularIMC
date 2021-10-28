package com.example.myimc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun execute(view: View) {
        if (edtWeight.text.toString().isEmpty() || edtHeight.text.toString().isEmpty()) {
            Toast.makeText(this, "Por favor, preencha os campos", Toast.LENGTH_SHORT).show()
            return
        }

        executeCalc()
    }

    private fun executeCalc() {
        val peso = edtWeight.text.toString().toDouble()
        val altura = edtHeight.text.toString().toDouble()
        val resultado = peso/(altura*altura)

        when {
            resultado < 18.5 -> {
                txtResult.text = "${resultado.format()} -> Peso baixo"
                txtResult.setTextColor(Color.BLUE)
            }
            resultado < 25 -> {
                txtResult.text = "${resultado.format()} -> Peso adequado"
                txtResult.setTextColor(Color.GREEN)
            }
            resultado < 30 -> {
                txtResult.text = "${resultado.format()} -> Sobrepeso"
                txtResult.setTextColor(Color.BLACK)
            }
            else -> {
                txtResult.text = "${resultado.format()} -> Obesidade"
                txtResult.setTextColor(Color.RED)
            }
        }
    }

    private fun Double.format() = DecimalFormat("#.##").format(this)
}