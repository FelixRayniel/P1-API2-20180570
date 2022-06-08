package com.example.p1_api2_20180570.model

import androidx.room.Entity
import  androidx.room.PrimaryKey

@Entity(tableName = "Prestamo")

data class Prestamo (
    @PrimaryKey(autoGenerate = true)
    val Deudor: String,
    val Concepto: String,
    val Monto: Float

)