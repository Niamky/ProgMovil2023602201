package com.example.holatoast

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.holatoast.ui.theme.HolaToastTheme
import androidx.compose.material3.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { UIPrincipal()}
    }
}

@Composable
fun UIPrincipal() {
    val contexto = LocalContext.current
    var nombre by remember {mutableStateOf("")}
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

        Text(modifier = Modifier.clickable(onClick = { Toast.makeText(contexto, "Tu Nombre:", Toast.LENGTH_SHORT).show() }), text = "Tu Nombre:")

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Inserta tu nombre") })

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
                Toast.makeText(contexto, "Hola $nombre!", Toast.LENGTH_SHORT).show()
            }) {
            Text("Saludo")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    UIPrincipal()
}