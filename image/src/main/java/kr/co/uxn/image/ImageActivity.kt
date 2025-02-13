package kr.co.uxn.image

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import kr.co.uxn.image.ui.theme.ComposePracticeTheme

class ImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                ImageEx()
            }
        }
    }
}

@Composable
fun ImageEx() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // 스텝1 : Image를 만들어보자.
        // painter항목에 painterResource(id = R.drawable.wall)
        // contentDescripton에 엔텔로프 캐년이라고 넣자.
        Image(
            painter = painterResource(R.drawable.wall),
            contentDescription = "엔텔로프 캐년"
        )

        // 스텝2 : 두 번째 Image를 만들어봦.
        // imageVector에 Icons.Filled.Settings를 설정해보자.
        Image(
            imageVector = Icons.Filled.Settings,
            contentDescription = "세팅"
        )

        // bitmap은 액티비티나 프래그먼트의 context가 필요해서 순수 compose로는 구현할 수 없다.
//        Image(
//            bitmap = ,
//            contentDescription =
//        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeTheme {
        ImageEx()
    }
}