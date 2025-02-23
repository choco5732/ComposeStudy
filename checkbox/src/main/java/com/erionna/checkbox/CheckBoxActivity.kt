package com.erionna.checkbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.erionna.checkbox.ui.theme.ComposePracticeTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

class CheckBoxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                CheckBoxEx()
            }
        }
    }
}

@Composable
fun CheckBoxEx() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 스텝 1 : checked 속성을 false로 넣어 CheckBox만들기
//        Checkbox(
//            checked = false,
//            onCheckedChange = {} // 바꼈을 때, 처리할 곳
//        )
//
//        // 스텝 2 : onCheckedChange에서 boolean  값 변수를 바꾸고
//        // checked에서 그 값을 반영해보자.
//
//        var ischecked = false
//
//        Checkbox(
//            checked = ischecked, // false값이 바뀌지 않으면 눌러도 반응이 없다.
//            onCheckedChange = {
//                ischecked = !ischecked
//            }
//        )
//        Text(
//            text = "반갑읍니다"
//        )

        // 위 코드가 잘 작동하지 않는다.
        // primitive 타입은 영향을 주지 않는다.
        // 컴포저블 함수나, 리컴포지션이라고 해서 다시 그려지는 절차가 있을때만 바뀐다.

        // 스텝 3 : boolean 대신 remember { mutableStateOf(false)}
        // 를 사용하여 상태를 바꿔보자. (value 프로퍼티를 사용해야 함)
        // 컴포저블은 언제든지 리컴포지션이 될 수 있기 때문에, 상태를 저장해주지 않으면
        // 날아갈 위험이 있다. remember 사용해야됨
//        var ischecked = remember { mutableStateOf(false) }
//        Checkbox(
//            checked = ischecked.value, // false값이 바뀌지 않으면 눌러도 반응이 없다.
//            onCheckedChange = {
//                ischecked.value = !ischecked.value
//            }
//        )
//        Text(
//            text = "반갑읍니다"
//        )
        // destruction : 비구조화, 반구조화, 구조분해
        val (a, b) = listOf(2, 3)

        // 스텝 4 : delegated properties로 변경해보자.

        // 위임된 속성
        // checked가 프로퍼티인 것 처럼 사용할 수 있음, .value하지 않아도 됨
//        var ischecked by remember { mutableStateOf(false) }
//        Checkbox(
//            checked = ischecked, // false값이 바뀌지 않으면 눌러도 반응이 없다.
//            onCheckedChange = {
//                ischecked = !ischecked
//            }
//        )
//        Text(
//            text = "반갑읍니다"
//        )

        // 스텝 5: destruction으로 상태를 받아서 사용해보자.
        // getter, setter
        val (getChecked, setChecked) = remember { mutableStateOf(false) }
        Checkbox(
            checked = getChecked, // false값이 바뀌지 않으면 눌러도 반응이 없다.
            onCheckedChange = {
                setChecked(!getChecked)
                setChecked(it)
            }
//            onCheckedChange = setChecked
        )
        // 아래와 같이 설정하면, 텍스트를 눌렀을때도, 체크박스를 눌렀을때와 동일한 효과가 나타남.
        Text(
            text = "반갑읍니다",
            modifier = Modifier.clickable {
                setChecked(!getChecked)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeTheme {
        CheckBoxEx()
    }
}