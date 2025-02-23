package com.erionna.topappbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.erionna.topappbar.ui.theme.ComposePracticeTheme

class TopAppBarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                    TopBarEx(
                        name = "Android"
                    )

            }
        }
    }
}

@Composable
fun TopBarEx(name: String) {
    Column {
        TopAppBar(title = { Text("TopAppBar")})
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeTheme {
        TopBarEx("hi")
    }
}