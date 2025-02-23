package com.erionna.slotapi

import android.os.Bundle
import android.widget.CheckBox
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.erionna.slotapi.ui.theme.ComposePracticeTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class SlotAPIActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                SlotAPIEx()
            }
        }
    }
}


// SlotAPI란?
// Composable함수가 다른 Composable함수를 포함하게 되어있는 것 (예: Column, Row, TopAppbar)
@Composable
fun SlotAPIEx() {
    var checked1 = remember { mutableStateOf(false) }
    // 위임된 프로퍼티
    var checked11 by remember { mutableStateOf(false) }
    var checked2 = remember { mutableStateOf(false) }

    Column {
//        CheckBoxWithText(checked1, "텍스트1")
//        CheckBoxWithText(checked2, "텍스트2")

//        CheckBoxWithSlot(checked1, {Text(text = "텍스트1")})
//        // content를 마지막인자로 받으면, 괄호 밖으로 뺄 수 있다.
//        CheckBoxWithSlot(checked2) {
//            Text(text = "텍스트2", modifier = Modifier.align(Alignment.CenterVertically))

        CheckBoxWithSlot(checked11, { checked11 = !checked11 },{ Text(text = "텍스트1") })
        // content를 마지막인자로 받으면, 괄호 밖으로 뺄 수 있다.
        CheckBoxWithSlot(
            checked = checked2.value,
            onCheckedChanged = { checked2.value = !checked2.value }
        ) {
            Text(text = "텍스트2", modifier = Modifier.align(Alignment.CenterVertically))
        }
    }
}

// 스텝 1 : Row를 @Composable 함수로 분리하자.
//@Composable
//fun CheckBoxWithText(checked: MutableState<Boolean>, text: String) {
//    Row(verticalAlignment = Alignment.CenterVertically) {
//        Checkbox(
//            checked = checked.value,
//            onCheckedChange = { checked.value = it }
//        // it : onCheckChange에서 반전한 값을 주는데 그것을 활용.
//        )
//        Text(
//            text = text,
//            modifier = Modifier.clickable { checked.value = !checked.value }
//        )
//    }
//}

// 스텝 2 : @Composable 함수에서 @Composable () -> Unit 타입으로 content를 받아오자.
//@Composable
//fun CheckBoxWithSlot(
//    checked: MutableState<Boolean>,
//    content: @Composable () -> Unit
//) {
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier.clickable {
//            checked.value = !checked.value
//        }
//    ) {
//        Checkbox(
//            checked = checked.value,
//            onCheckedChange = { checked.value = it }
//        )
//        content()
//    }
//}

// 스텝 3 : content의 타입을 @Composable RowScope.() -> Unit으로 바꾸자.
// 위와같이 인자로, 컴포저블 컨텐트를 넣는 방식을 Slot API라고 한다.
// 체계적으로 UI를 만들기에 적합한 방식이다.
//@Composable
//fun CheckBoxWithSlot(
//    checked: MutableState<Boolean>,
//    content: @Composable RowScope.() -> Unit // 이렇게 하면, 해당 람다 안이 RowScope가 적용된다.
//    // 따라서, 반드시 위와 같이 적용시켜줘야, content 안에 Row Scope에서만 쓸 수 있는 CenterVertically 를 사용할 수 있다.
//) {
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier.clickable {
//            checked.value = !checked.value
//        }
//    ) {
//        Checkbox(
//            checked = checked.value,
//            onCheckedChange = { checked.value = it }
//        )
//        content()
//    }
//}

// 스텝 4 : 상태를 바꾸는 람다를 @Composable 함수의 인자로 빼, 내부가 아닌 외부에서 상태를 결정하게 하자.
@Composable
fun CheckBoxWithSlot(
    checked: Boolean,
    onCheckedChanged: () -> Unit,
    content: @Composable RowScope.() -> Unit // 이렇게 하면, 해당 람다 안이 RowScope가 적용된다.
    // 따라서, 반드시 위와 같이 적용시켜줘야, content 안에 Row Scope에서만 쓸 수 있는 CenterVertically 를 사용할 수 있다.
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            onCheckedChanged()
        }
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckedChanged() }
        )
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeTheme {
        SlotAPIEx()
    }
}