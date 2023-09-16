package com.example.a04_09_2023

class Convertidor() {
    //Atributos
    var meter: Int = 0
    var feet: Double = 0.0
    var inch: Double = 0.0
    var yard: Double = 0.0

    fun calculateFeet(){
        if(this.meter > 0){
            this.feet = this.meter * 3.2808
        }
    }//calculateFeet

    fun calculateInch() {
        if (this.meter > 0){
            this.inch = this.meter * 39.3701
        }
    }//calcularPies

    fun calculateYard(){
        if(this.meter > 0){
            this.yard = this.meter * 1.09361
        }
    }//calcularPies
}//class