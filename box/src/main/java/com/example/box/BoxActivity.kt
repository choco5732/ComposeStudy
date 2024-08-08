package com.example.box

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.box.ui.theme.ComposePracticeTheme

/**
 * Box : FrameLayout 과 같이 중첩시키는 용도로 사용
 */
class BoxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                BoxExample()
            }
        }
    }
}

@Composable
fun BoxExample() {
//    Box(
//        modifier = Modifier.size(300.dp)
//    ) {
//        Text(
//            text = "박스 테스트!!",
//            modifier = Modifier.align(
//                Alignment.BottomEnd)
//            )
//    }

    // 스텝 1 : Text 두 개를 Box 안에 배치하라
//    Box(
//        modifier = Modifier.fillMaxSize()
//    ) {
//        Text(
//            text = "내 꿈은 네이버 개발자!",
//            modifier = Modifier.align(Alignment.TopStart)
//        )
//        Text(
//            text = "존버는 승리한다",
//            modifier = Modifier.align(Alignment.Center)
//        )
//        Text(
//            text = "이곳에 모든걸 놓고왔다. 누려라.",
//            modifier = Modifier.align(Alignment.BottomEnd)
//        )
//    }
    // 스텝 2 : 2개의 Box를 Box안에 배치하고, 사이즈를 70dp, 색상을 각기 다르게 해보라.
//    Box(
//        modifier = Modifier.width(100.dp)
//    ) {
//        Box(
//            modifier = Modifier
//                .size(70.dp)
//                .background(Color.Cyan)
//                .align(Alignment.Center)
//        )
//
//        Box(
//            modifier = Modifier
//                .size(70.dp)
//                .background(Color.Yellow)
//                .align(Alignment.CenterEnd)
//        )
//    }
    // 스텝 3 : 부모 Box에 modifier 설정을 제거해서, 콘텐트 사이즈만큼 보여라.
    Box {
        Box(modifier = Modifier.fillMaxSize().background(Color.Cyan).align(Alignment.CenterStart))
        Box(modifier = Modifier.size(80.dp).background(Color.DarkGray).align(Alignment.Center))
    }
}

@Preview(showBackground = true)
@Composable
fun BoxExamplePreview() {
    ComposePracticeTheme {
        BoxExample()
    }
}