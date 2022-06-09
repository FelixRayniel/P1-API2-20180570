package com.example.p1_api2_20180570

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.p1_api2_20180570.ui.theme.P1API220180570Theme
import com.example.p1_api2_20180570.ui.theme.prestamo.ListadoPrestamo
import com.example.p1_api2_20180570.ui.theme.prestamo.RegistroPrestamo
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            P1API220180570Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Pantalla.ListadoPrestamo.route) {

        composable(route = Pantalla.ListadoPrestamo.route){
            ListadoPrestamo(navController = navController)
        }
        composable(route = Pantalla.RegistroPrestamo.route){
            RegistroPrestamo(navController = navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    P1API220180570Theme {
        MyApp()
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}


@Composable
fun RegistroOcupacion(){

    val scaffoldState = rememberScaffoldState()
    var ocupacion by rememberSaveable() {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro de Ocupaciones")})
        },
        scaffoldState = scaffoldState
    ) {
        Column(modifier = Modifier.padding(8.dp)){
            OutlinedTextField(
                label = {
                    Text(text = "OcupacionId")
                },

                value = ocupacion,
                onValueChange = {ocupacion = it},
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                label = {
                    Text(text = "Nombre Ocupacion")
                },

                value = ocupacion,
                onValueChange = {ocupacion = it},
                modifier = Modifier.fillMaxWidth()
            )


            Row() {
                OutlinedButton(
                    onClick = {

                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = "Nuevo")
                }
                OutlinedButton(
                    onClick = {

                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = "Guardar")
                }
                OutlinedButton(
                    onClick = {

                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = "Eliminar")
                }
            }
        }
    }
}



