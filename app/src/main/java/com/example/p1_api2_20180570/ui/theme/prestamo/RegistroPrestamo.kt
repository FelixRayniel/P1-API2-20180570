package com.example.p1_api2_20180570.ui.theme.prestamo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun RegistroPrestamo(
    navController: NavHostController,
    viewModel: PrestamoViewModel = hiltViewModel(),
){

    val scaffoldState = rememberScaffoldState()
    var prestamo by rememberSaveable() {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro Prestamo") })
        },

        scaffoldState = scaffoldState

    ) {
        Column(modifier = Modifier.padding(8.dp)){

            OutlinedTextField(
                label = {
                    Text(text = "Deudor")
                },

                value = prestamo,
                onValueChange = {prestamo = it},
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                label = {
                    Text(text = "Concepto")
                },

                value = prestamo,
                onValueChange = {prestamo = it},
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                label = {
                    Text(text = "Monto")
                },

                value = prestamo,
                onValueChange = {prestamo = it},
                modifier = Modifier.fillMaxWidth()
            )


            Row() {

                Spacer(modifier = Modifier.width(20.dp))
                Button(onClick = {
                    viewModel.Guardar()
                    navController.navigate("ConsultaPrestamo")
                }) {
                    Modifier.padding(8.dp)
                    Text(text = "Guardar")
                }

            }
        }
    }
}