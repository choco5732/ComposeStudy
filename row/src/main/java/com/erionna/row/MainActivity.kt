package com.erionna.row

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erionna.row.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                RowEx()
            }
        }
    }
}

// Row : 가로로 배치
// Row가 가로이기 때문에 alignment는 항삭 수직이 된다.

@Composable
fun RowEx() {
//    Row(modifier = Modifier.height(40.dp)){
//        // width를 설정해주지 않으면 wrapContent로 이해
//        Text(text = "첫 번째!")
//        Text(text = "두 번째!")
//        Text(text = "세 번째!")
//    }

    // 스텝 1 : 각 text의 modifier에 align을 설정하자
//    Row(modifier = Modifier.height(40.dp)){
//        // width를 설정해주지 않으면 wrapContent로 이해
//        Text(text = "첫 번째!", modifier = Modifier.align(Alignment.Top)) // Row의 align은 진행방향의 수직인 세로로 할 수 있다.
//        Text(text = "두 번째!", modifier = Modifier.align(Alignment.CenterVertically))
//        Text(text = "세 번째!", modifier = Modifier.align(Alignment.Bottom))
//    }

    // 스텝 2 : Row에 verticalAlignment를 설정해보자
//    Row(
//        modifier = Modifier.height(40.dp),
//        verticalAlignment = Alignment.CenterVertically
//    )  {
//        // width를 설정해주지 않으면 wrapContent로 이해
//        Text(text = "첫 번째!", modifier = Modifier.align(Alignment.Bottom)) // Row의 align은 진행방향의 수직인 세로로 할 수 있다.
//        Text(text = "두 번째!")
//        Text(text = "세 번째!")
//    }

    // 스텝 3 : Row의 width를 20dp로 설정하자
    Row(
        modifier = Modifier
            .width(200.dp)
            .height(40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "첫 번째!", modifier = Modifier.align(Alignment.Bottom)) // Row의 align은 진행방향의 수직인 세로로 할 수 있다.
        Text(text = "두 번째!")
        Text(text = "세 번째!")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeTheme {
        RowEx()
    }
}