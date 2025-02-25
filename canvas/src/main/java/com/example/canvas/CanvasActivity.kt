package com.example.canvas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.canvas.ui.theme.ComposePracticeTheme

class CanvasActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CanvasEx()
                }
            }
        }
    }
}

@Composable
fun CanvasEx() {
    Canvas(
        modifier = Modifier.size(20.dp)
//        modifier = Modifier.fillMaxSize()
    ) {

        // 단계 1: `drawLine`을 사용해봅시다. 파라미터로 색상, 시작(`Offset`)
        // 끝(`Offset` 타입)을 받습니다.
        drawLine(Color.Red, Offset(40f, 10f), Offset(50f, 40f))
        // 단계 2: `drawCircle`을 사용해보세요. 색상, 반지름, 중앙(`Offset`)
        drawCircle(Color.Yellow, 10f, Offset(15f, 30f))
        // 가운데 offset : 시작위치
        drawRect(Color.Magenta, Offset(30f, 30f,), Size(10f, 10f))
        // 단계 3: 아래의 규칙으로 그려진 아이콘 `Icons.Filled.Send`를
        // `drawLine`으로 변경해봅시다.
//        Icons.Filled.Send
        // ImageVector에서는 한붓 그리기 처럼 연속으로 그려집니다.
        // `moveTo`로 2.01f, 21.0f로 이동한 후 거기에서
        // 23.0f, 12.0f로 선이 그어지는 식입니다.

        //        moveTo(2.01f, 21.0f) 여기서 시작,
        //        lineTo(23.0f, 12.0f) 요기까지 그림
        //        lineTo(2.01f, 3.0f)
        //        lineTo(2.0f, 10.0f)
        //        lineToRelative(15.0f, 2.0f) 위 위치에서 상대적인 위치까지 그림
        //        lineToRelative(-15.0f, 2.0f)
        //        close() 첫 위치로 이동
        drawLine(Color.Green, Offset(2.01f, 21.0f), Offset(23.0f, 12.0f))
        drawLine(Color.Green, Offset(23.01f, 12.0f), Offset(2.01f, 3.0f))
        drawLine(Color.Green, Offset(2.01f, 3.0f), Offset(2.0f, 10.0f))
        drawLine(Color.Green, Offset(2.0f, 10.0f), Offset(17.0f, 12.0f))
        drawLine(Color.Green, Offset(17.0f, 12.0f), Offset(2.0f, 14.0f))
        drawLine(Color.Green, Offset(2.0f, 14.0f), Offset(2.01f, 21.0f))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeTheme {
        CanvasEx()
    }
}