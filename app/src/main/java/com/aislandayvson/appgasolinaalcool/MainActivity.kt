package com.aislandayvson.appgasolinaalcool

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class MainActivity : AppCompatActivity() {

    private lateinit var textInputAlcool: TextInputLayout
    private lateinit var editAlcool: TextInputEditText

    private lateinit var textInputGasolina: TextInputLayout
    private lateinit var editGasolina: TextInputEditText

    private lateinit var btnCalcular: Button
    private lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniciarComponentesDeInterface()
        btnCalcular.setOnClickListener {
            calcularMelhorPreco()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun calcularMelhorPreco() {
        val precoAlcool = editAlcool.text.toString()
        val precoGasolina = editGasolina.text.toString()

        val resultadoValidacao = validarCampos(precoAlcool, precoGasolina)
        if(resultadoValidacao){
            val total = precoAlcool.toDouble() / precoGasolina.toDouble()
            if(total >= 0.7){
                textResultado.text = "Melhor usar gasolina"
            }else{
                textResultado.text = "Melhor usar álcool"
            }
        }
    }

    private fun validarCampos(pAlcool: String, pGasolina: String): Boolean {
        textInputGasolina.error = null
        textInputAlcool.error = null

        if(pAlcool.isEmpty()){
            textInputAlcool.error = "Digite o preço do álcool"
            return false
        }else if(pGasolina.isEmpty()){
            textInputGasolina.error = "Digite o preço da gasolina"
            return false
        }

        /*if (pAlcool.isEmpty() || pGasolina.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha ambos os campos!", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true
    }

    private fun iniciarComponentesDeInterface(){
        textInputAlcool = findViewById(R.id.text_input_alcool)
        editAlcool = findViewById(R.id.edit_alcool)

        textInputGasolina = findViewById(R.id.text_input_gasolina)
        editGasolina = findViewById(R.id.edit_gasolina)

        btnCalcular = findViewById(R.id.btn_calcular)
        textResultado = findViewById(R.id.text_resultado)
    }
}

