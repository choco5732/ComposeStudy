package com.example.modifier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
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
//        modifier = Modifier.fillMaxSize()
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Person,
//            contentDescription = "주소록"
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text(
//            text = "주소록"
//        )
//
//    }

    // 스텝 2 : fillMaxSize대신 Modifier.height를 설정해보자.
//    Button(
//        onClick = {},
//        modifier = Modifier.height(100.dp)
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Person,
//            contentDescription = "주소록"
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text(
//            text = "주소록"
//        )

        // 스텝 3 : modifier에 height와 width를 같이 설정해보자
//        Button(
//            onClick = {},
//            modifier = Modifier
//                .height(100.dp)
//                .width(150.dp)
//        ) {
//            Icon(
//                imageVector = Icons.Filled.Person,
//                contentDescription = "주소록"
//            )
//            Spacer(
//                modifier = Modifier.size(ButtonDefaults.IconSpacing)
//            )
//            Text(
//                text = "주소록"
//            )

        // 스텝 4 : size에 width와 height를 인자로 넣을 수 있다.
            // width와 height를 동시에 처리할 때는, size를 이용하는걸 권장
//            Button(
//                onClick = {},
//                modifier = Modifier
//                    .size(200.dp, 150.dp)
//            ) {
//                Icon(
//                    imageVector = Icons.Filled.Person,
//                    contentDescription = null
//                )
//                Spacer(
//                    modifier = Modifier.size(ButtonDefaults.IconSpacing)
//                )
//                Text(
//                    text = "주소록"
//                )
        // 스텝 5 : background를 설정
    // 버튼 색상은 modifier가아닌 colors 파라미터를 이용한다.
//    Button(
//        onClick = {},
//        modifier = Modifier.height(100.dp),
//        shape = RectangleShape,
//        colors = ButtonDefaults.buttonColors(
//            contentColor = Color.Magenta,
//            backgroundColor = Color.Cyan
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
//        modifier = Modifier.size(200.dp).padding(10.dp),
//        shape = RectangleShape,
//        colors = ButtonDefaults.buttonColors(
//            backgroundColor = Color.Yellow,
//            contentColor = Color.Gray
//        )
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Create,
//            contentDescription = "제작",
//            )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text(text = "제작중")
//    }

        // 스텝 7 : Button에 enabled를 false로 설정하고, Text의 modifier에 clickable을 넣어보자.
        // Button에 enable를 false로 두면, 버튼의 일부 요소에서만 클릭되게 설정할 수 있다.
//    Button(
//        colors = ButtonDefaults.buttonColors(
//            contentColor = Color.Magenta,
//            backgroundColor = Color.Yellow
//        ),
//        onClick = {},
//        enabled = false,
//        modifier = Modifier.width(200.dp).height(100.dp),
//        shape = RectangleShape,
//    ) {
//        Icon(
//            imageVector = Icons.Filled.FavoriteBorder,
//            contentDescription = "사랑"
//        )
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
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Magenta,
            backgroundColor = Color.Yellow
        ),
        onClick = {},
        modifier = Modifier.width(200.dp).height(100.dp),
        shape = RectangleShape,
    ) {
        Icon(
            imageVector = Icons.Filled.FavoriteBorder,
            contentDescription = "사랑",
            modifier = Modifier.background(Color.Blue)
        )
        Spacer(
            modifier = Modifier
                .size(ButtonDefaults.IconSpacing)
                .background(Color.Blue)
        )
        Text(
            text= "좋은 버튼",
            modifier = Modifier.offset(x = 30.dp, y = 15.dp)
        )
    }

        // Icon과 Text, Spacer는 modifier로 backgorund를 설정해줄 수 있는데,
        // Button은 colors로 background를 설정해 줘야 한다.
}

@Preview
@Composable
fun GreetingPreview() {
    ComposePracticeTheme {
        ModifierExample()
    }
}