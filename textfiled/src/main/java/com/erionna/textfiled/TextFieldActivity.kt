package com.erionna.textfiled

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erionna.textfiled.ui.theme.ComposePracticeTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

class TextFieldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                TextFiledEx()
            }
        }
    }
}

@Composable
fun TextFiledEx() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        // 스텝 1 : TextField를 Text위에 만들어보자.
//        TextField(
//            value = "Tom",
//            onValueChange = {}
//        )

        // 스텝 2 : Text에 Android대신 TextField 입력을 출력해보자.
        // mutableStateOf("") 필드를 하나 만들자.
        var name by remember { mutableStateOf("장재용") }
//        TextField(
//            value = name,
//            onValueChange = { name = it}
//        )
//        Text(
//            text = "Hello $name"
//        )

        // 스텝 3 : TextField에 label을 추가해보자.
//        TextField(
//            value = name,
//            label = {
//                Text("이름")
//            },
//            onValueChange = { name = it}
//        )

        // 스텝 4 : TextField와 Text사이에 Spacer를 넣어 8.dp 간격을 주자.
//        TextField(
//            value = name,
//            label = {
//                Text(
//                    text = "이름",
//                    fontSize = 10.sp,
//                    color = Color.Magenta
//                )
//            },
//            onValueChange = { name = it}
//        )
//        Spacer(modifier = Modifier.size(8.dp))
        // 스텝 5 : TextField를 OutlinedTextField로 변경해보자.
        // 외각선이 사라진 TextField
        // 버튼도 OutlinedButton이 있다.
        OutlinedTextField(
            value = name,
            label = {
                Text(
                    text = "이름",
                    fontSize = 10.sp,
                    color = Color.Magenta
                )
            },
            onValueChange = { name = it}
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = "Hello $name"
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposePracticeTheme {
        TextFiledEx()
    }
}