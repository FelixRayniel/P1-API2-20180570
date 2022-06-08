package com.example.p1_api2_20180570

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.p1_api2_20180570.Utilidades.Pantalla
import com.example.p1_api2_20180570.ui.theme.P1API220180570Theme

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
    val navHostController = rememberNavController( )

    NavHost(navController = navHostController, startDestination = Pantalla.ListadoPaciente.route) {

        composable(Pantalla.ListadoPaciente.route){
            ListadoPaciente(clickRegitro = {navHostController.navigate(Pantalla.RegistroPaciente.route)})
        }
        composable(route = Pantalla.RegistroPaciente.route){
            RegistroPaciente()
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
fun ListadoPaciente(clickRegitro:() ->Unit){
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        topBar = {
            TopAppBar(title = {Text(text = "Listado")})

        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    clickRegitro()
                },
                backgroundColor = Color.Cyan

            ) {

            }
        },
        scaffoldState = scaffoldState
    ) {
        Column(modifier = Modifier.padding(10.dp)) {



        }

    }
}

@Composable
fun RowNombre(nombre: String){
    Row(){
        Text("Nombre : $nombre")
    }
}

@Composable
fun RegistroPaciente(){

    val scaffoldState = rememberScaffoldState()
    var paciente by rememberSaveable() {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro")})
        },

        scaffoldState = scaffoldState

    ) {
        Column(modifier = Modifier.padding(8.dp)){
            OutlinedTextField(
                label = {
                    Text(text = "PacienteId")
                },

                value = paciente,
                onValueChange = {paciente = it},
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                label = {
                    Text(text = "Nombres")
                },

                value = paciente,
                onValueChange = {paciente = it},
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                label = {
                    Text(text = "Cedula")
                },

                value = paciente,
                onValueChange = {paciente = it},
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                label = {
                    Text(text = "Email")
                },

                value = paciente,
                onValueChange = {paciente = it},
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                label = {
                    Text(text = "Telefono")
                },
                value = paciente,
                onValueChange = {paciente = it},
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
                    Icon(imageVector = Icons.Default.Delete, contentDescription =null )
                    Text(text = "Eliminar")
                }
            }
        }
    }
}