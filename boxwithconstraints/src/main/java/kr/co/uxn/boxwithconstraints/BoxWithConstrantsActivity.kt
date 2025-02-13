package kr.co.uxn.boxwithconstraints

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.uxn.boxwithconstraints.ui.theme.ComposePracticeTheme

// BoxWithConstrants는 길이(width, height)에 따라 요소를 추가할 때, 사용한다.
class BoxWithConstrantsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            ComposePracticeTheme {
                Outer()
            }
        }
    }
}

@Composable
fun Outer() {
    // 스텝 4 : Column에 width를 지정해서 제한해 보자.
    Column {
        // 스텝 2 : Inner의 인자로 Modifier.withIn(min = 100.dp)를 전달해보자.
        // heightIn도 전달해보자. 각각 인자의 max값도 전달해보자.
        Inner(
            modifier = Modifier
                .height(160.dp)
        )
    }
}

// 스텝 1 : Inner 인자로 modifier를 전달해보자. 기본값을 Modifier로 지정하자.
// 파라미터로 받은 modifier를 BoxWithConstraints에 전달하자.
@Composable
fun Inner(modifier: Modifier = Modifier) { // 기본값으로 Modifier를 설정해두면 함수를 호출할때 인자를 비워도 괜찮다.
    BoxWithConstraints(modifier) {
        // 스텝 3 : maxHeight값이 150dp가 넘을 때만 추가로 텍스트를 출력해보자.
        if (maxHeight > 150.dp) {
            Text("상당히 길군요")
        }
        Text("maxW:$maxWidth maxH:$maxHeight minW: $minWidth minH:$minHeight")
        // 위 값은 연결한 기기에 따라 달라진다

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeTheme {
        Outer()
    }
}