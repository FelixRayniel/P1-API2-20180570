package com.example.p1_api2_20180570.ui.theme.prestamo


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.p1_api2_20180570.data.Repository.PrestamoRepository
import com.example.p1_api2_20180570.model.Prestamo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PrestamoViewModel @Inject constructor(
    val prestamoRepository: PrestamoRepository

) : ViewModel(){

    var deudor by mutableStateOf("")
    var concepto by mutableStateOf(" ")
    var monto by mutableStateOf(0.00f)

    var prestamo = prestamoRepository.getList()

    fun Guardar(){
        viewModelScope.launch {
            prestamoRepository.insertar(
                Prestamo(
                    Deudor = deudor,
                    Concepto = concepto,
                    Monto = monto
                )
            )
        }
    }

}