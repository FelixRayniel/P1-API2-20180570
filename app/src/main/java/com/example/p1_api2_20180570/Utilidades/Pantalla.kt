package com.example.p1_api2_20180570.Utilidades

sealed class Pantalla(val route: String) {

    object ListadoPaciente : Pantalla("ListadoPaciente")
    object RegistroPaciente : Pantalla("RegistroPaciente")

}

