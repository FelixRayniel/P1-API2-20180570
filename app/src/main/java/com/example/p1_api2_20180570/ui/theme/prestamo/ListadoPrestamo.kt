package com.example.p1_api2_20180570.ui.theme.prestamo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun ListadoPrestamo(
    navController: NavHostController,
    viewModel: PrestamoViewModel = hiltViewModel()
){
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Listado Prestamo") })

        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            val list = viewModel.prestamo.collectAsState(initial = emptyList())

            Button(onClick = { navController.navigate("RegistroPrestamo") }) {
                Text(text = "Prestamo")
            }
            Column {
                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    items(list.value) { prestamo ->
                        RowPrestamo(
                            deudor = prestamo.Deudor,
                            concepto = prestamo.Concepto,
                            monto = prestamo.Monto,


                            )
                    }
                }
            }


        }
    }
}

@Composable
fun RowPrestamo(deudor: String, concepto: String, monto: Float) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text("Deudor : $deudor")
        Text("Concepto : $concepto")
        Text("Monto : $monto")
    }
}