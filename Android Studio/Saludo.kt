package com.example.holamundo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.holamundo.ui.theme.HolamundoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { UIPrincipal()}
    }
}

@Composable
fun UIPrincipal() {
    var strTxtNombre by remember { mutableStateOf("")}
    var strLblMessage by remember { mutableStateOf("")}

    fun btnSaludar_click(){
        strLblMessage = "Hola $strTxtNombre"
    }

   Column (Modifier.fillMaxSize().padding(16.dp), Arrangement.Top, Alignment.Start){
       Text("¿Cómo te llamas?")
       TextField(value = strTxtNombre, onValueChange = {strTxtNombre = it})
       Button(onClick = {btnSaludar_click()}){
           Text("Saludar")
       }
       Text(strLblMessage)
   }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    UIPrincipal()
}