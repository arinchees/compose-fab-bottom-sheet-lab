package ru.yandex.practicum.fabsheetlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                FabBottomSheetScreen()
            }
        }
    }
}

@Composable
fun FabBottomSheetScreen() {
    var showBottomSheet by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.safeDrawing),
    ) {
        Text(
            text = "Нажмите +, чтобы открыть панель",
            modifier = Modifier.align(Alignment.Center),
            textAlign = TextAlign.Center,
        )
        FloatingActionButton(
            onClick = { showBottomSheet = true },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(32.dp),
            shape = CircleShape,
            containerColor = Color.Gray,
            contentColor = Color.White,
        ) {
            Text(text = "+", fontSize = 28.sp)
        }
    }

    ExampleBottomSheet(
        isVisible = showBottomSheet,
        onDismiss = { showBottomSheet = false },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExampleBottomSheet(isVisible: Boolean, onDismiss: () -> Unit) {
    if (isVisible) {
        ModalBottomSheet(
            onDismissRequest = onDismiss,
            sheetState = rememberModalBottomSheetState(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = "Это панель BottomSheet")
                Text(text = "⌂", fontSize = 32.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FabBottomSheetScreenPreview() {
    MaterialTheme {
        FabBottomSheetScreen()
    }
}
