package com.erionna.constraintlayout_chain_barrier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.erionna.constraintlayout_chain_barrier.ui.theme.ComposePracticeTheme

class ConstraintLayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                ConstraintLayoutEx()
            }
        }
    }
}

@Composable
fun ConstraintLayoutEx() {
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (redBox, yellowBox, magentaBox, text) = createRefs()
        // 단계 3 : 세 박스의 top을 parent.top에 연결하고 각각 다른 마진을 주자.
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .constrainAs(redBox) {
                    top.linkTo(parent.top, margin = 18.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox) {
                    top.linkTo(parent.top, margin = 32.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .constrainAs(magentaBox) {
                    top.linkTo(parent.top, margin = 60.dp)
                }
        )
        // 단계 1 : createVerticalChain, createHorizontalChain을 이용해 세 박스의 레퍼런스를 연결하자.
//        createVerticalChain(redBox, yellowBox, magentaBox)
//        createHorizontalChain(redBox, yellowBox, magentaBox)

        // 단계 2 : createHorizontalChain을 사용하고, chainStyle 키워드 파라미터를 추가하자.
        // ChainStyle.Packed, ChainStyle.Spread, ChainStyle.SpreadInside 등을 설정해보자.
        createHorizontalChain(redBox, yellowBox, magentaBox, chainStyle = ChainStyle.SpreadInside)


        // 단계 4 : createBottomBarrier로 배리어를 만들자.
        // 배리어란? 세 개의 박스 중 가장 낮은곳에 배치하고 싶을 때 사용
        val bottomBarrier = createBottomBarrier(redBox, yellowBox, magentaBox)
        val topBarrier = createTopBarrier(redBox, yellowBox, magentaBox)
        val startBarrier = createStartBarrier(redBox, yellowBox, magentaBox)
        val endBarrier = createEndBarrier(redBox, yellowBox, magentaBox)

        // 단계 5 : Text 하나 만들고 top을 박스 배리어로 지정하자.
        Text(
            text = "배리어 잘 만들어졌나 한번 볼까? 배리어 잘 만들어졌나 한번 볼까? 배리어 잘 만들어졌나 한번 볼까? 배리어 잘 만들어졌나 한번 볼까? " ,
            modifier = Modifier.constrainAs(text) {
                top.linkTo(bottomBarrier)
            }
        )

    }


// 단계 4 : createBottomBarrier로 배리어를 만들자.
    // 단계 5 : Text 하나 만들고 top을 박스 배리어로 지정하자.
    // 단계 6 : 체이닝 방향이나 배리어 방향을 바꾸어 다양하게 테스트해보자.
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposePracticeTheme {
        ConstraintLayoutEx()
    }
}