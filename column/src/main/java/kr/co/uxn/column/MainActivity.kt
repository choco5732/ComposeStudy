package kr.co.uxn.column

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.uxn.column.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePracticeTheme {
                ColumnEx()
            }
        }
    }
}

@Composable
fun ColumnEx() {

    // 스텝 1 : horizontalAlignment를 Column에 적용하자.
    // Alignment는 레이아웃의 방향과 반대, 따라서 Column에서는 수평방향
//    Column(
//        horizontalAlignment = Alignment.End,
//        modifier = Modifier.size(100.dp)
//    ) {
//        Text(
//            text = "첫 번째"
//        )
//        Text(
//            text = "두 번째"
//        )
//        Text(
//            text = "세 번째"
//        )
//    }
    // 스텝 2 : Column에 verticalArrangement를 적용해 보자
    // SpaceAround, SpaceEvenly, SpaceBetween도 같이
    // Arrangement는 레이아웃 방향과 동일, 따라서 Column에서는 수직방향
//    Column(
//        verticalArrangement = Arrangement.SpaceAround,
//        horizontalAlignment = Alignment.End,
//        modifier = Modifier.size(100.dp)
//    ) {
//        Text(
//            text = "첫 번째"
//        )
//        Text(
//            text = "두 번째"
//        )
//        Text(
//            text = "세 번째"
//        )
//    }
    // 스텝3 : Text에 Modifier.align을 사용해 보자.
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.size(100.dp)
    ) {
        Text(
            text = "첫 번째",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = "두 번째"
        )
        Text(
            text = "세 번째"
        )
    }

    // Column과 Row 1차원 Alignment,
    // Box는 2차원 Alignment가 가능하다.
}

@Preview(showBackground = true)
@Composable
fun ColumnPreview() {
    ComposePracticeTheme {
        ColumnEx()
    }
}