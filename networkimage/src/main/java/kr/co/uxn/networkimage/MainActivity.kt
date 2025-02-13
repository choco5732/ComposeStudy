package kr.co.uxn.networkimage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberImagePainter
import kr.co.uxn.networkimage.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 네트워크 이미지를 불러올 떄는, 프리뷰가 작동안한다. 따라서 예뮬레이터로 확인해야 한다.
        setContent {
            ComposePracticeTheme {
                CoilEx()
            }
        }
    }
}

@Composable
fun CoilEx() {
    val painter = rememberImagePainter(
        data = "https://mblogthumb-phinf.pstatic.net/20160817_259/retspe_14714118890125sC2j_PNG/%C7%C7%C4%AB%C3%F2_%281%29.png?type=w800"
    )
    // remeber는 컴포즈가 재호출 됬을 때, 기억했다가 알려주는 역할을 한다.

    Column {
        // 1. 구글이 추천하는방식, 그러나 deprecated
        Image(
            painter = painter,
            contentDescription = "엔텔로프 캐넌"
        )

        // 2. 코일이 추천하는 방식
        AsyncImage(
            model = "https://mblogthumb-phinf.pstatic.net/20160817_259/retspe_14714118890125sC2j_PNG/%C7%C7%C4%AB%C3%F2_%281%29.png?type=w800",
            contentDescription = "이미지"
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeTheme {
        CoilEx()
    }
}