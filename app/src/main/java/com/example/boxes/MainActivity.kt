package com.example.boxes

import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import com.example.boxes.ui.theme.BoxesTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Encabezado()
        DosCajas()
        ListaDeElementos()
        Spacer(modifier = Modifier.weight(1f))  // Esto empuja el PieDePagina hacia abajo
        PieDePagina()
    }
}

@Composable
fun Encabezado() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.Cyan),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Encabezado", fontSize = 24.sp, color = Color.Black)
    }
}



@Composable
fun Cajas(color: Color, title: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(410.dp)
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = title, fontSize = 20.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /* Acción */ },
                shape = RoundedCornerShape(50)
            ) {
                Text(text = "Acción")
            }
        }
    }
}


@Composable
fun DosCajas(){
    Row(modifier = Modifier.fillMaxWidth()){
        Cajas(color = Color.Red, title = "Caja 1", modifier = Modifier.weight(1f))
        Cajas(color = Color.Yellow, title = "Caja2", modifier = Modifier.weight(1f))
    }
}

@Composable
fun ListaDeElementos() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Gray)
            .padding(16.dp)
    ) {
        Text(text = "Lista de Elementos", fontSize = 20.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(8.dp))
        ElementoLista(text = "Hamburguesa")
        ElementoLista(text = "Pizza")
        ElementoLista(text = "Hot Dog")
        ElementoLista(text = "Tacos")
        ElementoLista(text = "Helados")
    }
}

@Composable
fun ElementoLista(text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Icon(
            imageVector = Icons.Default.DateRange,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text, fontSize = 16.sp)
    }
}

@Composable
fun PieDePagina() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color.Magenta),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Pie de página", fontSize = 20.sp, color = Color.Black)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}
