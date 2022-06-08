package com.example.p1_api2_20180570.Utilidades

sealed class Pantalla(val route: String) {

    object ListadoPrestamo : Pantalla("ListadoPrestamo")
    object RegistroPrestamo : Pantalla("RegistroPrestamo")

}

