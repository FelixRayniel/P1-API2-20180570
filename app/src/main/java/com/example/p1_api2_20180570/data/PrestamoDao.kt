package com.example.p1_api2_20180570.data

import androidx.room.*
import com.example.p1_api2_20180570.model.Prestamo
import kotlinx.coroutines.flow.Flow

@Dao
interface PrestamoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(prestamo: Prestamo)

    @Delete
    suspend fun eliminar(prestamo: Prestamo)

    @Query("SELECT * FROM prestamo WHERE prestamoId =:prestamoId")

    fun buscar(prestamoId: Int): Flow<Prestamo>

    @Query("SELECT * FROM prestamo ORDER BY prestamoId")
    fun getList(): Flow<List<Prestamo>>

}
