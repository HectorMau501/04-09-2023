package com.example.a04_09_2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    //Intancias para componentes graficos
    //Cajas de texto

    private lateinit var metros: EditText
    private lateinit var pies: Chip
    private lateinit var  pulgadas: Chip
    private lateinit var  yardas: Chip
    private lateinit var resultado: TextView
    private lateinit var  opciones: ChipGroup
    //Declaracion de instancia de clase
    private lateinit var obj: Convertidor

    //FORMATO PARA REPRESENTAR CANTIDAD DE DECIMALES
        private val formatoDecimales: DecimalFormat = DecimalFormat("#.##")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        metros = findViewById(R.id.editMetros)
        pies = findViewById(R.id.chPies)
        pulgadas = findViewById(R.id.chPulgadas)
        yardas = findViewById(R.id.chYardas)
        resultado = findViewById(R.id.txtResultado)
        opciones = findViewById(R.id.gpoOpciones)

        //Inicializar instancias de clase
        obj = Convertidor()
    }

    fun onClick(v: View?){
        when(v?.id){
            R.id.ibtnConvertir -> {
                btnConvertir()
            }
            R.id.ibtnMostrar -> {
                btnMostrar()
            }
            R.id.ibtnLimpiar -> {
                btnLimpiar()
            }
        }
    }//onClick

    private fun btnLimpiar() {
        metros.text = null
        resultado.text = "Cantidad de metros Convertida a: \n"
        opciones.clearCheck()
        metros.requestFocus()
        obj = Convertidor()
    }//btnLimpiar

    private fun btnMostrar() {
        var res: String = "Cantidad de metros convertida a: \n"
        res += "Pies: "+ formatoDecimales.format(obj.feet) + "\n"
        res += "Pulgadas : "+ formatoDecimales.format(obj.inch) + "\n"
        res += "Yardas: "+ formatoDecimales.format(obj.yard) + "\n"
        resultado.text = res
    }//btnMostrar

    private fun btnConvertir() {
        //Validar que hay valor y espacios
        if(metros.text.isNotEmpty() && metros.text.isNotBlank()){
            //Obtener cantidad en metros
            obj.meter = metros.text.toString().toInt()
            //Evaluar la opcion seleccionada para calular
            if(pies.isChecked) obj.calculateFeet()
            if(pulgadas.isChecked) obj.calculateInch()
            if(yardas.isChecked) obj.calculateYard()
            Toast.makeText(applicationContext,"Metros convertidos.",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(applicationContext,"Ingresa cantidad en metros.",Toast.LENGTH_SHORT).show()
        }
    }//btnConvertir
}