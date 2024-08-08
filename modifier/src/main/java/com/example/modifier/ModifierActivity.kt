package com.example.modifier

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.modifier.ui.theme.ComposePracticeTheme

class ModifierActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                ModifierExample(
                )
            }
        }
    }
}


@Composable
fun ModifierExample() {
//    Button(onClick = {}) {
//        Icon(
//            imageVector = Icons.Filled.Create,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text(text = "제작")
//    }

    // 스텝 1 : modifier에 Modifier.fillMaxSize()를 사용해보자
//    Button(
//        onClick = {},
//        modifier = Modifier.fillMaxSize(),
//        shape = RectangleShape
//        ) {
//        Icon(
//            imageVector = Icons.Filled.Create,
//            contentDescription = null,
//
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text(text = "제작")
//    }

    // 스텝 2 : fillMaxSize대신 Modifier.height를 설정해보자.
//    Button(
//        onClick = {},
//        modifier = Modifier.height(100.dp),
//        shape = RectangleShape
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Create,
//            contentDescription = null,
//
//            )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text(text = "제작")
//    }

    // 스텝 3 : modifier에 height와 width를 같이 설정해보자
//    Button(
//        onClick = {},
//        modifier = Modifier
//            .height(100.dp)
//            .width(200.dp),
//        shape = RectangleShape
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Create,
//            contentDescription = null,
//
//            )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text(text = "제작")
//    }

    // 스텝 4 : size에 width와 height를 인자로 넣을 수 있다.
//    Button(
//        onClick = {},
//        modifier = Modifier.size(200.dp, 100.dp),
//        shape = RectangleShape
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Create,
//            contentDescription = null,
//
//            )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text(text = "제작")
//    }

    // 스텝 5 : background를 설정
//    Button(
//        onClick = {},
//        modifier = Modifier.height(100.dp),
//        shape = RectangleShape,
//        colors = ButtonDefaults.buttonColors(
//            containerColor = Color.Yellow,
//            contentColor = Color.Gray
//        )
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Create,
//            contentDescription = null,
//
//            )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text(text = "제작")
//    }

    // 스텝 6 : Button의 modifier에 padding 넣어보기
//    Button(
//        onClick = {},
//        modifier = Modifier.padding(10.dp),
//        shape = RectangleShape,
//        colors = ButtonDefaults.buttonColors(
//            containerColor = Color.Yellow,
//            contentColor = Color.Gray
//        )
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Create,
//            contentDescription = null,
//            )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text(text = "제작")
//    }

    // 스텝 7 : Button에 enabled를 false로 설정하고, Text의 modifier에 clickable을 넣어보자.
//    Button(
//        onClick = {},
//        modifier = Modifier.width(200.dp).height(100.dp),
//        shape = RectangleShape,
//        colors = ButtonDefaults.buttonColors(
//            containerColor = Color.Magenta,
//            contentColor = Color.Yellow
//        ),
//        enabled = false
//    ) {
//        Icon(
//            imageVector = Icons.Filled.FavoriteBorder,
//            contentDescription = "사랑"
//        )
//
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text(
//            text= "좋은 버튼",
//            modifier = Modifier.clickable {}
//        )
//    }

    // 스텝 8 : Button의 modifier에 offset을 설정하고 x 파라미터를 설정하라.
    Button(
        onClick = {},
        modifier = Modifier.width(200.dp).height(100.dp),
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Magenta,
            contentColor = Color.Yellow
        ),
        enabled = false
    ) {
        Icon(
            imageVector = Icons.Filled.FavoriteBorder,
            contentDescription = "사랑",
            modifier = Modifier.background(Color.Cyan)
        )

        Spacer(
            modifier = Modifier
                .width(30.dp)
                .background(Color.Black)
        )
        Text(
            text= "좋은 버튼",
            modifier =  Modifier
                .offset(x = -10.dp )
                .background(Color.Blue
                )
        )
    }

    // Icon과 Text, Spacer는 modifier로 backgorund를 설정해줄 수 있는데,
    // Button은 modifier대신 colors를 이용해야한다.

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposePracticeTheme {
        ModifierExample()
    }
}