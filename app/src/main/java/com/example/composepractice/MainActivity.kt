package com.example.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice.ui.theme.ComposePracticeTheme

// compose에서는 legacy와의 차이점이 ComponentActivity()를 상속받는다.

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // 보통 앱 이름에 기반해서 테마를 만들어준다.
            ComposePracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Composable : 컴포즈에서 UI를 구성하는 단위
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    // 스텝 1: 색상을 지정하기 위해 color 파라미터에 Color.RED를 전달해보자.
//    Text(text = "안녕 $name", color = Color.Red) // Ui.graphics

//     스템 2: Color 객체를 이용해서 해쉬값으로 색상을 전달해보자. (ARGB 순)
//    Text(text = "안녕 $name", color = Color(0xffffff44))

    // 스텝 3: fontSize 파라미터에 30.sp를 전달해보자
//    Text(text = "안녕 $name", color = Color(0xffffff44), fontSize = 30.sp)

    // 스텝 4: fontWeight에 FontWeight.Bold를 전달해보자.
//    Text(text = "안녕", color = Color.Cyan, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)

    // 스텝 5: fontFamily에 FontFamily.Cursive를 전달해보자.
//    Text(
    //    text = "안녕 $name",
//        color = Color.Cyan,
//        fontSize = 20.sp,
//        fontWeight = FontWeight.ExtraBold,
//        fontFamily = FontFamily.Cursive
//    )

    // 스텝 6: letterSpacing에 2.sp를 해보자.
//    Text(
//        text = "안녕 \n$name",
//        color = Color.Cyan,
//        fontSize = 20.sp,
//        fontWeight = FontWeight.ExtraBold,
//        fontFamily = FontFamily.Cursive,
//        letterSpacing = 2.sp
//    )

    // 스텝 7: maxLines를 3로 지정하고 문자열을 더 추가해보자.
//    Text(
//        text = "안녕 \n$name\n 안녕\n안녕",
//        color = Color.Cyan,
//        fontSize = 20.sp,
//        fontWeight = FontWeight.ExtraBold,
//        fontFamily = FontFamily.Cursive,
//        letterSpacing = 2.sp,
//        maxLines = 3
//    )

    // 스텝 8 : textDecoration에 TextDecoration.Underline을 추가해보자.
//    Text(
//        text = "안녕 \n$name\n 안녕\n안녕",
//        color = Color.Cyan,
//        fontSize = 20.sp,
//        fontWeight = FontWeight.ExtraBold,
//        fontFamily = FontFamily.Cursive,
//        letterSpacing = 2.sp,
//        maxLines = 3,
//        textDecoration = TextDecoration.Underline
//    )

    // 스텝 8 : textAlign을 TextAlign.Center로 지정해보자.
    Text(
        modifier = Modifier.width(300.dp),
        text = "안뇽\n안뇽\n안뇽\n안뇽",
        color = Color.Blue,
        fontSize = 30.sp,
        fontWeight = FontWeight.Thin,
        letterSpacing = 3.sp,
        maxLines = 4,
        textDecoration = TextDecoration.LineThrough,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposePracticeTheme {
        Greeting("Android")
    }
}