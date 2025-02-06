package com.erionna.row

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
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
//    Row(
//        modifier = Modifier.height(40.dp)
//    ){
//        Text(
//            text = "첫번째"
//        )
//        Text(
//            text = "두번째"
//        )
//        Text(
//            text = "세번째"
//        )
//    }

    // 스텝 1 : 각 text의 modifier에 align을 설정하자
//    Row(
//        modifier = Modifier
//            .height(40.dp)
//    ){
//        Text(
//            text = "첫번째",
//            modifier = Modifier.align(Alignment.Bottom)
//            // row의 align은 수직방향이다. 진행방향과 수직방향
//        )
//        Text(
//            text = "두번째",
//            modifier = Modifier.align(Alignment.CenterVertically)
//            // Center는 쓸수없다. 왜냐면, 그것은 vertical, horizontal다 center라 적용안됨
//        )
//        Text(
//            text = "세번째",
//            modifier = Modifier.align(Alignment.Top)
//        )
//    }

    // 스텝 2 : Row에 verticalAlignment를 설정해보자
//    Row(
//        modifier = Modifier.height(40.dp),
//        verticalAlignment = Alignment.Bottom
//        // 위와 같이 쓰면 각 요소마다 modifier에 Aligment.Bottom한 것과 동일한 효과를 보여준다.
//    ){
//        Text(
//            text = "첫번째",
//            modifier = Modifier.align(Alignment.Top)
//        )
//        Text(
//            text = "두번째",
////            modifier = Modifier.align(Alignment.Bottom)
//        )
//        Text(
//            text = "세번째",
////            modifier = Modifier.align(Alignment.Bottom)
//        )
//    }

    // 스텝 3 : Row의 width를 200dp로 설정하자
    // Row에 horizontalArrangement에 Arrangement.Center를 설정해보자.
    // Start, End, SpaceAround, SpaceBetween, SpaceEvenly를 설정해보자.

    // ArrangeMent는 Row의 진행방향과 동일하게 수평방향이 된다.
//    Row(
//        horizontalArrangement = Arrangement.SpaceAround,
//        verticalAlignment = Alignment.Bottom,
//        modifier = Modifier
//            .width(200.dp)
//            .height(40.dp)
//    ) {
//        Text(
//            text = "첫 번째",
//            modifier = Modifier.align(Alignment.Top)
//        )
//        Text(
//            text = "두 번째",
//            modifier = Modifier.align(Alignment.Top)
//        )
//        Text(
//            text = "세 번째",
//            modifier = Modifier.align(Alignment.Top)
//        )
//    }
    // 스텝 4 : 각 텍스트의 weight를 설정해보자.
//    Row(
//        modifier = Modifier.fillMaxSize(),
//        horizontalArrangement = Arrangement.SpaceAround
//    ){
//        Text(
//            text = "안녕하세요",
//            modifier = Modifier.weight(3f)
//        )
//        Text(
//            text = "반갑습니다",
//            modifier = Modifier.weight(1f)
//        )
//        Text(
//            text = "안녕히가세요",
//            modifier = Modifier.weight(3f))
//    }
    // 스텝 5 : Text대신 Icon을 넣어보자.
    // Text의 textAlign을 설정해보자.
    Row(
        modifier = Modifier.size(200.dp, 40.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = "첫번째",
            textAlign = TextAlign.End,
            modifier = Modifier
                .background(Color.Magenta)
                .weight(3f)
        )
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "추가",
            modifier = Modifier
                .weight(1f)
                .background(Color.Yellow)
        )
        Text(
            text = "두번째",
            modifier = Modifier
                .weight(3f)
                .background(Color.Cyan),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeTheme {
        RowEx()
    }
}