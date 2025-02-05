package com.example.surface

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.surface.ui.theme.ComposePracticeTheme

/**
 * Surface
 * Material Design의 핵심
 * cliffing, elevation(그림자),
 */
class SurfaceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                SurfaceExample()
            }
        }
    }
}

/**
 * Compose에서는 margin이 없고 padding으로 모든 여백을 처리한다.
 * Surface가 구성품들의 최상단에 위치하고, padding으로 외각 여백을 처리하고
 * 각 구성원들이 또 그들만의 내각 여백을 처리하는 구조다.
 * 예를 들어 text에 마진을 주고싶으면 padding을 이용하는데
 * text 외각에 surface를 주고, surface에 padding을 줌으로써 margin의 효과를 준다.
 * (성능적 향상을 위해 이렇게 한다고한다.)
 */
@Composable
fun SurfaceExample() {
//    Surface(
//        modifier = Modifier.padding(5.dp)
//    ) {
//        Text(
//            text = "Hello",
//            modifier = Modifier.padding(8.dp)
//        )
//    }

    // 스텝 1 : Surface에 elevation을 설정하라.
//    elevation : 그림자를 줘서 입체감을 주는 역할
//    Surface(
//        modifier = Modifier.padding(20.dp),
//        elevation = 10.dp
//    ) {
//        Text(
//            text = "안녕하세요 좋은 아침입니다.",
//            modifier = Modifier.padding(50.dp)
//        )
//    }
    // 스텝 2 : border 값을 설정하라.
//    Surface(
//        border = BorderStroke(
//            width = 3.dp,
//            color = Color.Magenta
//        ),
//        modifier = Modifier.padding(5.dp),
//        elevation = 4.dp
//    ) {
//        Text(
//            text= "허허 반갑읍니다!",
//            modifier = Modifier.padding(18.dp)
//        )
//    }
    // 스텝 3 : Surface의 shape도 설정하라.
//    Surface(
//        border = BorderStroke(
//            width = 2.dp,
//            color = Color.Magenta
//        ),
//        modifier = Modifier.padding(5.dp),
//        elevation = 5.dp,
//        shape = RectangleShape
//    ) {
//        Text(
//            text= "허허 반갑읍니다!",
//            modifier = Modifier.padding(8.dp)
//        )
//    }
    // 스텝 4 : color를 지정하라.
    Surface(
        border = BorderStroke(
            width = 2.dp,
            color = Color.Magenta
        ),
        modifier = Modifier.padding(5.dp),
        elevation = 4.dp,
        shape = CircleShape,
        color = MaterialTheme.colors.primary
        // 배경색은 primary로, 글자색은 자동으로 onPrimary가 된다.
    ) {
        Text(
            text= "허허 반갑읍니다!",
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SurfaceExamplePreview() {
    ComposePracticeTheme {
        SurfaceExample()
    }
}