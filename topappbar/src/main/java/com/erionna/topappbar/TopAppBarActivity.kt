package com.erionna.topappbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.erionna.topappbar.ui.theme.ComposePracticeTheme

class TopAppBarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                TopBarEx()
            }
        }
    }
}


@Composable
fun TopBarEx() {
    Column {
//        TopAppBar()
        CustomTopAppBar()

    }
}


@Composable
fun TopAppBar() {
    // 스텝 1 : TopAppBar를 만들고 title을 만들어보자.
    TopAppBar(
        title = { Text("컴포즈 공부") },
        // 스텝 2 : navigationIcon 파라미터를 채워보자.
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "업 네비게이션"
                )
            }
        },
        // 스텝 3 : actions를 추가해보자. ( Icons.Filled 활용)
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "검색"
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "설정"
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.AccountBox,
                    contentDescription = "계정"
                )
            }
        }
    )
}


// 스텝 4 : TopAppBar content 파라미터 버전을 만들어보자.
@Composable
fun CustomTopAppBar() {
    TopAppBar {
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "업 네비게이션"
            )
        }
        Text("컴포즈 공부", modifier = Modifier.weight(1f)) // weight가 한개 뿐이면 얘가 가능한 모든 사이즈를 잡아먹는다.
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "검색"
            )
        }
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = "설정"
            )
        }
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Filled.AccountBox,
                contentDescription = "계정"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeTheme {
        TopBarEx()
    }
}