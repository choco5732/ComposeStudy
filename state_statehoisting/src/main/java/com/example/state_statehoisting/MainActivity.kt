package com.example.state_statehoisting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.state_statehoisting.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PyeongToSquareMeter()
                }
            }
        }
    }
}

@Composable
fun PyeongToSquareMeter() {
    // remember는 configuration(회전)이 발생했을 땐, 상태가 유지되지 않는다.
    // 따라서 configuration에도 상태가 유지되는 rememberSaveable을 써야한다.
    // 다만, 저장공간에 한계가 있다는 점 또는 무겁다는 점 유의해야한다.
    var pyeong by rememberSaveable {
        mutableStateOf("")
    }
    var squareMeter by rememberSaveable {
        mutableStateOf("")
    }

    // rememberScaffoldState()  유틸리티
    // remember , rememberSaveable 근본

    // 단계 1: remember를 이용해 상태를 만들고 평 값을 입력하면
    // 제곱미터가 출력되도록 화면을 구성하시오.
    // 평을 제곱미터로 바꾸기 위해서는 3.306을 곱하면 됩니다.
//    Column(modifier = Modifier.padding(16.dp)) {
//        OutlinedTextField(
//            value = pyeong,
//            onValueChange = {
//                // EditText안의 내용이 다 안 지워지는 경우
//                if (it.isBlank()) {
//                    pyeong = ""
//                    squareMeter = ""
//                    return@OutlinedTextField
//                }
//
//                val numericValue = it.toFloatOrNull() ?: return@OutlinedTextField
//                // 1013A와 같은 이상한 값이 입력되는걸 방지하기위해서,
//                // Float으로 만들 수 없는 값은
//                // null로 설정하겠다는 의미
//                pyeong = it
//                squareMeter = (numericValue * 3.306f).toString()
//            }, label = {
//                Text("평")
//            }
//        )
//        OutlinedTextField(
//            value = squareMeter,
//            onValueChange = {
//
//            },
//            label = {
//                Text("제곱미터")
//            }
//        )
//    }
    PyeongToSquareMeterStateless(
        pyeong,
        squareMeter
    ) {
        if (it.isBlank()) {
            pyeong = ""
            squareMeter = ""
            return@PyeongToSquareMeterStateless
        }

        val numericValue = it.toFloatOrNull() ?: return@PyeongToSquareMeterStateless
        // 1013A와 같은 이상한 값이 입력되는걸 방지하기위해서,
        // Float으로 만들 수 없는 값은
        // null로 설정하겠다는 의미
        pyeong = it
        squareMeter = (numericValue * 3.306f).toString()
    }

}

// StateHoisting : 상태를 OutlinedTextFiled까지 전달하는건 안티패턴이다.
//                 가능한 상태가 전달되는 범위를 좁히기 위해서 상태를 윗단으로 끌어올리는 것을 StateHoisting이라고 한다.
// 단계 2: `Composable` 함수를 만들고 `Column`의 항목들을 옮기세요.
// 단 상태는 옮기지 말아야 합니다.

// StateHoisting을 하는 이유 : 확장성을 위함이다. 상태 코드와, UI코드를 분리함으로써, 추후에 상태코드만 변경하면 되기에 유지보수에 용이하다.

// 파라미터는 아래와 같이 구성합니다.
// `pyeong: String, squareMeter: String, onPyeongChange: (String) -> Unit`
@Composable
fun PyeongToSquareMeterStateless(
    pyeong: String,
    squareMeter: String,
    onPyeongChange: (String) -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = pyeong,
            onValueChange = onPyeongChange,
            label = {
                Text("평")
            }
        )
        OutlinedTextField(
            value = squareMeter,
            onValueChange = {},
            label = {
                Text("제곱미터")
            }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeTheme {
        PyeongToSquareMeter()
    }
}