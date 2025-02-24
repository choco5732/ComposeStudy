package com.example.constraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.constraintlayout.ui.theme.ComposePracticeTheme

class ConstraintLayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ConstraintLayoutEx()
                }
            }
        }
    }
}

@Composable
fun ConstraintLayoutEx() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        // 단계 2 : createRefs()를 이용해 아래 박스들의 레퍼런스를 가져오자.
        // createRefs는 여러개의 레퍼런스를 리턴하니 destruction으로 분해하자.
        // red, magenta, green, yellow 박스가 있다.
        val (redBox, magentaBox, greenBox, yellowBox) = createRefs() // ConstraintLayout안에서 쓸 수 있는 함수

        // 단계 3 : constraintAs 모디파이어를 추가하고 레퍼런스를 전달하자.
        // 후행 람다로 top, start, end, bottom 앵커를 지정하고
        // linkTo를 설정하자.
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .constrainAs(redBox) {
                    bottom.linkTo(parent.bottom, margin = 8.dp)
                    end.linkTo(parent.end, margin = 4.dp)
                }
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .constrainAs(magentaBox) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Green)
                .constrainAs(greenBox) {
                    // 매번 아래와같이 해주면 번거로움 centerTo를 하면 편리함
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                    top.linkTo(parent.top)
//                    bottom.linkTo(parent.bottom)
                    centerTo(parent)
//                    centerHorizontallyTo(parent)
//                    centerVerticallyTo(parent)

                }
        )
        // 단계 8 : 마젠타 박스의 오른쪽에 아래에 두어라.
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox) {
                    start.linkTo(magentaBox.end)
                    top.linkTo(magentaBox.bottom)
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ConstraintLayoutExPreview() {
    ComposePracticeTheme {
        ConstraintLayoutEx()
    }
}