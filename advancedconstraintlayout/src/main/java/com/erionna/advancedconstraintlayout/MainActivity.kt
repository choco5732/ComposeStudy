package com.erionna.advancedconstraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.erionna.advancedconstraintlayout.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    data class CardData(
        val imageUri: String,
        val imageDescription: String,
        val author: String,
        val description: String
    )

    companion object {
        val cardData = CardData(
            imageUri = "https://raw.githubusercontent.com/Fastcampus-Android-Lecture-Project-2023/part4-chapter3/main/part4-chapter3-10/app/src/main/res/drawable-xhdpi/wall.jpg",
            imageDescription = "엔텔로프 캐년",
            author = "Dalinaum",
            description = "엔텔로프 캐년은 죽기 전에 꼭 봐야할 절경으로 소개되었습니다."
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        CardEx(cardData)
                        CardEx(cardData)
                        CardEx(cardData)
                    }
                }
            }
        }
    }
}

@Composable
fun CardEx(cardData: MainActivity.CardData) {
    val placeHolderColor = Color(0x33000000)

    Card(
        elevation = 8.dp,
        modifier = Modifier.padding(4.dp)
    ) {
        // 단계1 : 아래의 Row 레이아웃을 ConstraintLayout으로 바꿔보자.
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model =
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposePracticeTheme {
        CardEx()
    }
}