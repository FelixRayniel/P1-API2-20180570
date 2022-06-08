package com.example.p1_api2_20180570.data.Repository

import com.example.p1_api2_20180570.data.PrestamoDao
import com.example.p1_api2_20180570.model.Prestamo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PrestamoRepository @Inject constructor(
    val prestamoDao: PrestamoDao
) {
    suspend fun insertar(prestamo: Prestamo) {
        prestamoDao.insertar(prestamo)
    }

    suspend fun eliminar(prestamo: Prestamo) {
        prestamoDao.eliminar(prestamo)
    }

    fun buscar(prestamoId: Int): Flow<Prestamo> {
        return prestamoDao.buscar(prestamoId)
    }

    fun getList(): Flow<List<Prestamo>> {
        return prestamoDao.getList()
    }
}