package com.example.a04_09_2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import java.text.DecimalFormat
import android.widget.Toast

class RadioButtom : AppCompatActivity() {

    //Intancias para componentes graficos
    //Cajas de texto

    private lateinit var metros: EditText
    private lateinit var pies: RadioButton
    private lateinit var  pulgadas: RadioButton
    private lateinit var  yardas: RadioButton
    private lateinit var resultado: TextView
    private lateinit var  opciones: RadioGroup
    //Declaracion de instancia de clase
    private lateinit var obj: Convertidor

    //FORMATO PARA REPRESENTAR CANTIDAD DE DECIMALES
    private val formatoDecimales: DecimalFormat = DecimalFormat("#.##")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_buttom)


        metros = findViewById(R.id.editMetros2)
        opciones = findViewById(R.id.radiogroup)
        pies = findViewById(R.id.rbPies)
        pulgadas = findViewById(R.id.rbPulgadas)
        yardas = findViewById(R.id.rbYardas)
        resultado = findViewById(R.id.txtResultado2)

        //Inicializar instancias de clase
        obj = Convertidor()

    }//override
    fun onClick2(v: View?){
        when(v?.id){
            R.id.ibtnConvertir3 -> {
                btnConvertir2()
            }
            R.id.ibtnMostrar3 -> {
                btnMostrar2()
            }
            R.id.ibtnLimpiar3 -> {
                btnLimpiar2()
            }
        }
    }//onClick

    private fun btnLimpiar2() {
        metros.text = null
        resultado.text = "Cantidad de metros Convertida a: \n"
        opciones.clearCheck()
        metros.requestFocus()
        obj = Convertidor()
    }//btnLimpiar

    private fun btnMostrar2() {
        var res: String = "Cantidad de metros convertida a: \n"
        res += "Pies: "+ formatoDecimales.format(obj.feet) + "\n"
        res += "Pulgadas : "+ formatoDecimales.format(obj.inch) + "\n"
        res += "Yardas: "+ formatoDecimales.format(obj.yard) + "\n"
        resultado.text = res
    }//btnMostrar

    private fun btnConvertir2() {
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