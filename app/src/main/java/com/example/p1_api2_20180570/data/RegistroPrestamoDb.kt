package com.example.p1_api2_20180570.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.p1_api2_20180570.model.Prestamo


@Database(
    entities = [Prestamo::class],
    exportSchema = false,
    version = 1
)

abstract class RegistroPrestamoDb : RoomDatabase() {

    abstract val personaDao: PrestamoDao
}