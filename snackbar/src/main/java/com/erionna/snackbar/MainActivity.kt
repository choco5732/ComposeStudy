package com.erionna.snackbar

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarResult
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.erionna.snackbar.ui.theme.ComposePracticeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePracticeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SnackbarEx()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SnackbarEx() {
    var counter by remember { mutableStateOf(0) }

    // 단계 3: couroutineScope를 만듭시다.
    // `rememberCoroutineScope`를 사용합니다.
    val coroutineScope = rememberCoroutineScope()
    // Snackbar가 suspension 함수이기에 코루틴 스코프를 이용한다.

    // 단계 1: scaffoldState를 만들고 Scaffold에 설정합시다.
    // scaffoldState를 만들기 위해 `rememberScaffoldState`를 사용합니다.
    val scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState) {
        // 단계 2: "더하기" 버튼을 만들어 봅시다.
        // action에서 counter를 증가시킵시다.
        Button(onClick = {
            counter++
            coroutineScope.launch {
                val result = scaffoldState.snackbarHostState.showSnackbar(
                    message = "카운터는 ${counter}입니다.",
                    actionLabel = "닫기",
                    duration = SnackbarDuration.Short
                )
                when (result) {
                    SnackbarResult.Dismissed -> {}
                    SnackbarResult.ActionPerformed -> {}
                }
            }
        }) {
            Text("더하기")
        }
        // 단계 4: 버튼의 onClick에서 `coroutineScope.launch`를
        // 사용합니다.

        // 단계 5: 스낵바를 사용하기 위해 `scaffoldState.snackbarHostState.showSnackbar`
        // 사용합니다.

        // `message`에 카운터를 출력합시다.
        // `actionLabel`를 "닫기"로 지정합시다.
        // `duration`에 `SnackbarDuration.Short`를 사용합니다.
        // LaunchedEffect는 onClick외부나 composable 안에서 부작용을 대비해 사용할수있따.
//        LaunchedEffect(scaffoldState.snackbarHostState) {
//            coroutineScope.launch {
//                scaffoldState.snackbarHostState.showSnackbar(
//                    message = "카운터는 ${counter}입니다.",
//                    actionLabel = "닫기",
//                    duration = SnackbarDuration.Short
//                )
//            }
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeTheme {
        SnackbarEx()
    }
}