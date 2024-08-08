package com.example.button

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.button.ui.theme.ComposePracticeTheme

class ButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                ButtonExample(
                    onButtonClicked = {
                        Toast.makeText(this, "버튼 눌림!", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }
}

@Composable
fun ButtonExample(onButtonClicked: () -> Unit) {
//    Button(onClick = {}) {
//        Text(text = "Send!") // 안에 여러개의 위젯 넣을 수 있음
//    }

    // 스텝 1 : Button을 클릭했을 때 Toast를 출력하라
//    Button(onClick = onButtonClicked) {
//        Text(text = "hi")
//    }
    // 스텝 2 : Icon을 Text 앞 에 추가하라.
    // ImageVector에는 Icons.FilledSend를 넣고,
    // contentDescription에는 null을 넣어보자.
//    Button(onButtonClicked) {
//        Icon(
//            imageVector = Icons.Filled.AccountBox,
//            contentDescription = null
//        )
//        Text(text = "Account")
//    }

    // 스텝 3 : 아이콘과 텍스트 사이에 Spacer를 넣어보자.
    // modifier에 Modifier.size를 넣고 사이즈를
    // ButtonDefaults.IconSpacing을 지정하자.
//    Button(onClick = onButtonClicked) {
//        Icon(
//            imageVector = Icons.Filled.Build,
//            contentDescription = "제작"
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text(text = "제작")
//    }
    // 스텝 4 : enabled를 false로 바꿔보자.
//    Button(
//            onClick = onButtonClicked,
//    enabled = false
//    ) {
//
//        Icon(
//            imageVector = Icons.Filled.Build,
//            contentDescription = "사랑"
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text(text = "hi")
//
//    }
    // 스텝 5 : border에 BorderStroke를 설정하자.
//    Button(
//        onClick = onButtonClicked,
//        enabled = true,
//        border = BorderStroke(width = 5.dp, Color.Magenta)
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Build,
//            contentDescription = "사랑"
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text(text = "hi")
//    }

    // 스텝 6 : shape를 CircleShape로 지정하자.
//    Button(
//        onClick = onButtonClicked,
//        enabled = true,
//        border = BorderStroke(width = 5.dp, Color.Magenta),
//        shape = CircleShape
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Build,
//            contentDescription = "사랑"
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.Ic
    //            onSpacing)
//        )
//        Text(text = "hi")
//    }

    // 스텝 7 : contentPadding에 PaddingValues를 설정하자.
    Button(
        onClick = onButtonClicked,
        enabled = true,
        border = BorderStroke(width = 5.dp, Color.Magenta),
        shape = CircleShape,
        contentPadding = PaddingValues(20.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Build,
            contentDescription = "사랑"
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing)
        )
        Text(text = "hi")
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonExamplePreview() {
    ComposePracticeTheme {
        ButtonExample(onButtonClicked = {}, )
    }
}