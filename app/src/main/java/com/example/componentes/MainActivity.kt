package com.example.componentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                PantallaLaboratorio()
            }
        }
    }
}

@Composable
fun PantallaLaboratorio() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(bottom = 100.dp)
    ) {
        item { Caja("1. Text") { ComponenteText() } }
        item { Caja("2. Button") { ComponenteButton() } }
        item { Caja("3. OutlinedButton") { ComponenteOutlinedButton() } }
        item { Caja("4. TextButton") { ComponenteTextButton() } }
        item { Caja("5. ElevatedButton") { ComponenteElevatedButton() } }
        item { Caja("6. FilledTonalButton") { ComponenteFilledTonalButton() } }
        item { Caja("7. Icon") { ComponenteIcon() } }
        item { Caja("8. IconButton") { ComponenteIconButton() } }
        item { Caja("9. FloatingActionButton") { ComponenteFAB() } }
        item { Caja("10. Checkbox") { ComponenteCheckbox() } }
        item { Caja("11. RadioButton") { ComponenteRadioButton() } }
        item { Caja("12. Switch") { ComponenteSwitch() } }
        item { Caja("13. Slider") { ComponenteSlider() } }
        item { Caja("14. LinearProgressIndicator") { ComponenteLinearProgress() } }
        item { Caja("15. CircularProgressIndicator") { ComponenteCircularProgress() } }
        item { Caja("16. TextField") { ComponenteTextField() } }
        item { Caja("17. OutlinedTextField") { ComponenteOutlinedTextField() } }
        item { Caja("18. Card") { ComponenteCard() } }
        item { Caja("19. ElevatedCard") { ComponenteElevatedCard() } }
        item { Caja("20. AssistChip") { ComponenteAssistChip() } }
        item { Caja("21. FilterChip") { ComponenteFilterChip() } }
        item { Caja("22. SuggestionChip") { ComponenteSuggestionChip() } }
        item { Caja("23. InputChip") { ComponenteInputChip() } }
        item { Caja("24. Badge") { ComponenteBadge() } }
        item { Caja("25. BadgedBox") { ComponenteBadgedBox() } }
        item { Caja("26. Divider") { ComponenteDivider() } }
        item { Caja("27. Surface") { ComponenteSurface() } }
        item { Caja("28. Spacer") { ComponenteSpacerDemo() } }
        item { Caja("29. Box") { ComponenteBox() } }
        item { Caja("30. Row") { ComponenteRow() } }
        item { Caja("31. Column") { ComponenteColumn() } }
        item { Caja("32. LazyRow") { ComponenteLazyRow() } }
        item { Caja("33. Image") { ComponenteImage() } }
    }
}

@Composable
fun Caja(titulo: String, contenido: @Composable () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(text = titulo, style = MaterialTheme.typography.titleMedium)
            contenido()
        }
    }
}

@Composable
fun ComponenteText() {
    Text("Hola, este es un Text", fontSize = 18.sp)
}

@Composable
fun ComponenteButton() {
    Button(onClick = {}) {
        Text("Button")
    }
}

@Composable
fun ComponenteOutlinedButton() {
    OutlinedButton(onClick = {}) {
        Text("OutlinedButton")
    }
}

@Composable
fun ComponenteTextButton() {
    TextButton(onClick = {}) {
        Text("TextButton")
    }
}

@Composable
fun ComponenteElevatedButton() {
    ElevatedButton(onClick = {}) {
        Text("ElevatedButton")
    }
}

@Composable
fun ComponenteFilledTonalButton() {
    FilledTonalButton(onClick = {}) {
        Text("FilledTonalButton")
    }
}

@Composable
fun ComponenteIcon() {
    Icon(
        imageVector = Icons.Default.Favorite,
        contentDescription = "Favorito",
        modifier = Modifier.size(40.dp)
    )
}

@Composable
fun ComponenteIconButton() {
    IconButton(onClick = {}) {
        Icon(Icons.Default.Settings, contentDescription = "Configuración")
    }
}

@Composable
fun ComponenteFAB() {
    FloatingActionButton(onClick = {}) {
        Icon(Icons.Default.Add, contentDescription = "Agregar")
    }
}

@Composable
fun ComponenteCheckbox() {
    var checked by remember { mutableStateOf(false) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checked, onCheckedChange = { checked = it })
        Text(if (checked) "Marcado" else "No marcado")
    }
}

@Composable
fun ComponenteRadioButton() {
    var seleccionado by remember { mutableStateOf(true) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = seleccionado,
            onClick = { seleccionado = !seleccionado }
        )
        Text(if (seleccionado) "Seleccionado" else "No seleccionado")
    }
}

@Composable
fun ComponenteSwitch() {
    var activo by remember { mutableStateOf(false) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Switch(checked = activo, onCheckedChange = { activo = it })
        Spacer(modifier = Modifier.width(8.dp))
        Text(if (activo) "Encendido" else "Apagado")
    }
}

@Composable
fun ComponenteSlider() {
    var valor by remember { mutableFloatStateOf(50f) }
    Column {
        Slider(
            value = valor,
            onValueChange = { valor = it },
            valueRange = 0f..100f
        )
        Text("Valor: ${valor.toInt()}")
    }
}

@Composable
fun ComponenteLinearProgress() {
    LinearProgressIndicator(progress = { 0.65f })
}

@Composable
fun ComponenteCircularProgress() {
    CircularProgressIndicator()
}

@Composable
fun ComponenteTextField() {
    var texto by remember { mutableStateOf("") }
    TextField(
        value = texto,
        onValueChange = { texto = it },
        label = { Text("Escribe tu nombre") }
    )
}

@Composable
fun ComponenteOutlinedTextField() {
    var clave by remember { mutableStateOf("") }
    OutlinedTextField(
        value = clave,
        onValueChange = { clave = it },
        label = { Text("Contraseña") },
        visualTransformation = PasswordVisualTransformation()
    )
}

@Composable
fun ComponenteCard() {
    Card {
        Text("Este es un Card simple", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun ComponenteElevatedCard() {
    ElevatedCard {
        Text("Este es un ElevatedCard", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun ComponenteAssistChip() {
    AssistChip(
        onClick = {},
        label = { Text("AssistChip") },
        leadingIcon = { Icon(Icons.Default.Info, contentDescription = null) }
    )
}

@Composable
fun ComponenteFilterChip() {
    var seleccionado by remember { mutableStateOf(false) }
    FilterChip(
        selected = seleccionado,
        onClick = { seleccionado = !seleccionado },
        label = { Text("FilterChip") }
    )
}

@Composable
fun ComponenteSuggestionChip() {
    SuggestionChip(
        onClick = {},
        label = { Text("SuggestionChip") }
    )
}

@Composable
fun ComponenteInputChip() {
    var visible by remember { mutableStateOf(true) }

    if (visible) {
        InputChip(
            selected = true,
            onClick = {},
            label = { Text("InputChip") },
            trailingIcon = {
                IconButton(onClick = { visible = false }) {
                    Icon(Icons.Default.Close, contentDescription = "Cerrar")
                }
            }
        )
    } else {
        Text("Chip eliminado")
    }
}

@Composable
fun ComponenteBadge() {
    Badge {
        Text("8")
    }
}

@Composable
fun ComponenteBadgedBox() {
    BadgedBox(
        badge = {
            Badge { Text("3") }
        }
    ) {
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Notificaciones",
            modifier = Modifier.size(32.dp)
        )
    }
}

@Composable
fun ComponenteDivider() {
    Column {
        Text("Arriba")
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        Text("Abajo")
    }
}

@Composable
fun ComponenteSurface() {
    Surface(
        tonalElevation = 4.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Text("Este es un Surface", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun ComponenteSpacerDemo() {
    Column {
        Text("Texto arriba")
        Spacer(modifier = Modifier.height(20.dp))
        Text("Texto abajo")
    }
}

@Composable
fun ComponenteBox() {
    Box(
        modifier = Modifier
            .size(120.dp)
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Text("Box")
    }
}

@Composable
fun ComponenteRow() {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Button(onClick = {}) { Text("Uno") }
        Button(onClick = {}) { Text("Dos") }
    }
}

@Composable
fun ComponenteColumn() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("Elemento 1")
        Text("Elemento 2")
        Text("Elemento 3")
    }
}

@Composable
fun ComponenteLazyRow() {
    val lista = listOf("A", "B", "C", "D", "E")
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(lista) { item ->
            Card {
                Text(text = item, modifier = Modifier.padding(16.dp))
            }
        }
    }
}

@Composable
fun ComponenteImage() {
    Icon(
        imageVector = Icons.Default.AccountCircle,
        contentDescription = "Imagen",
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .border(2.dp, Color.Gray, CircleShape)
    )
}