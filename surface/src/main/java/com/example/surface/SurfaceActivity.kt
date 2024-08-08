package com.example.surface

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

@Composable
fun SurfaceExample() {
    // 스텝 1 : Surface에 elevation을 설정하라.
//    Surface(
//        modifier = Modifier.padding(5.dp),
//        shadowElevation = 5.dp
//    ) {
//        Text(
//            text = "안녕하세요 좋은 아침입니다.",
//            modifier = Modifier.padding(8.dp)
//        )
//    }
    // 스텝 2 : border 값을 설정하라.
//    Surface(
//        border = BorderStroke(
//            width = 2.dp,
//            color = Color.Magenta
//        ),
//        modifier = Modifier.padding(5.dp),
//        shadowElevation = 4.dp
//    ) {
//        Text(
//            text= "허허 반갑읍니다!",
//            modifier = Modifier.padding(8.dp)
//        )
//    }
    // 스텝 3 : Surface의 shape도 설정하라.
//    Surface(
//        border = BorderStroke(
//            width = 2.dp,
//            color = Color.Magenta
//        ),
//        modifier = Modifier.padding(5.dp),
//        shadowElevation = 4.dp,
//        shape = CircleShape
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
        shadowElevation = 4.dp,
        shape = CircleShape,
        color = MaterialTheme.colorScheme.primary
        // 글자색은 onPrimary의 값으로 지정된다.
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