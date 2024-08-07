package com.erionna.button

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import com.erionna.button.ui.theme.ComposePracticeTheme

class ButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePracticeTheme {
                ButtonExample()
            }
        }
    }

}

@Composable
private fun ButtonExample() {
    Button(onClick = {}) {
        Text(text = "Send")
    }
}



@Preview(showBackground = true)
@Composable
fun ButtonExamplePreview() {
    ComposePracticeTheme {
        ButtonExample()
    }
}