package com.example.dialog_custom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.example.dialog_custom.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CustomDialog()
                }
            }
        }
    }
}

@Composable
fun CustomDialog() {
    var openDialog by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Button(onClick = {
            openDialog = true
        }) {
            androidx.compose.material.Text("다이얼로그 열기")
        }
        androidx.compose.material.Text("카운터: $counter")
    }

    if (openDialog) {
        Dialog(onDismissRequest = {
            // 단계 1: 디스미스 처리를 합니다.
        }) {
            Surface {
                // 단계 2: 컬럼을 만들고 설명을 적어봅시다.

                // 단계 3: 컬럼 안에 로우를 만들어 수평 방향으로 버튼을 배열합니다.
                // 버튼은 +1, -1, 취소로 구성하겠습니다.

                // +1은 counter를 증가시키고 -1은 감소, 취소는 다이얼로그를 닫습니다.
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeTheme {
        CustomDialog()
    }
}