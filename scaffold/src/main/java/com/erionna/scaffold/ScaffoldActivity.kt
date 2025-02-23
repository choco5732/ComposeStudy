package com.erionna.scaffold

import android.annotation.SuppressLint
import android.graphics.Paint.Align
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erionna.scaffold.ui.theme.ComposePracticeTheme

// Scaffold : SlotAPI의 확장판
class ScaffoldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                ScaffoldEx()
            }
        }
    }
}

@Composable
fun ScaffoldEx() {
    var checked by remember { mutableStateOf<Boolean>(false) }
    val context = LocalContext.current
    // drawer : 햄버거 버튼
    Scaffold(
        topBar = {
            // 스텝 1 : 'topBar'를 'TopAppBar'로 채워보자.`
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Image(
                            imageVector = Icons.Filled.ArrowBack, contentDescription = "뒤로가기"
                        )
                    }
                },
                title = {
                    Text(text = "Scaffold App")
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                Toast.makeText(
                    context,
                    "오우",
                    Toast.LENGTH_SHORT
                ).show()
            }) {

            }
        }
    ) { paddingValues ->
//        Surface(modifier = Modifier.padding(8.dp)) {
        Surface(
            modifier = Modifier
                .padding(paddingValues)
                .padding(8.dp)
        ) {
            // 스텝 2 : 아래에 checkBoxWithContent를 넣어보자.`
            CheckBoxWithContent(
                checked = checked,
                toggleState = { checked = !checked }
            ) {
                Text(text = "컴포즈를 좋아합니다?")
            }
        }
    }
}

@Composable
fun CheckBoxWithContent(
    checked: Boolean,
    toggleState: () -> Unit, // Row전체, checkBox 클릭 동일동작
    content: @Composable RowScope.() -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { toggleState() }
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { toggleState() }
        )
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeTheme {
        ScaffoldEx()
    }
}