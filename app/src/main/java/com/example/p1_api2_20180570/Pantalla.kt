package com.example.p1_api2_20180570

sealed class Pantalla(val route: String) {

    object ListadoPrestamo : Pantalla("ConsultaPrestamo")
    object RegistroPrestamo : Pantalla("RegistroPrestamo")


}

