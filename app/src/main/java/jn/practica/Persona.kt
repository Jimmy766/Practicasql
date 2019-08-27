package jn.practica

class Persona(nombre:String, apellido:String, telefono:String) {
    var nombre:String=nombre
    var apellido:String=apellido
    var telefono:String=telefono

    override fun toString(): String {
        return nombre+" "+apellido+" :  "+telefono
    }
}