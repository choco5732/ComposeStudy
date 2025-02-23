package com.erionna.catalog

import android.graphics.drawable.Icon
import android.os.Bundle
import android.os.ParcelFileDescriptor
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erionna.catalog.ui.theme.ComposePracticeTheme
import androidx.annotation.DrawableRes
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CatalogEx(items)
                }
            }
        }
    }
}

@Composable
fun CatalogEx(itemList: List<ItemData>) {
    LazyColumn { // Lazy : 필요할때만 보여주겠다.
        // 스텝 2 : items(itemList)를 이용해 Item을 반복해서 컬럼에 추가하자.
        // item : 한개씩,
        // items : 여러걔 삽입
        item {
            Item(itemList[0])
        }
        item {
            Item(itemList[1])
        }


        items(itemList) { item ->
            Item(item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CatalogExPreview() {
    ComposePracticeTheme {
        CatalogEx(items)
    }
}

@Composable
fun Item(itemData: ItemData) {
    Card(
        elevation = 8.dp,
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = itemData.imageId),
                contentDescription = itemData.title
            )
            Spacer(
                modifier = Modifier.size(8.dp)
            )
            Text(
                text = itemData.title,
                style = MaterialTheme.typography.h4
            )
            Spacer(
                modifier = Modifier.size(8.dp)
            )
            Text(
                text = itemData.description
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    ComposePracticeTheme{
        Item(
            ItemData(
                imageId = R.drawable.a1,
                title = "해변 놀이 공원",
                description = "해변 놀이 공원은 참으로 아름답습니다. 더 알고 싶으면 이 링크를 눌러주세요."
            )
        )
    }
}

data class ItemData(
    @DrawableRes  val imageId: Int,
    val title: String,
    val description: String
)

val items = listOf(
    ItemData(
        imageId = R.drawable.a1,
        title = "해변 놀이 공원",
        description = "해변 놀이 공원 설명입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.a2,
        title = "캐년",
        description = "미국의 캐년입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.a3,
        title = "워터월드",
        description = "워터월드입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.a4,
        title = "미국의 캐년",
        description = "미국의 캐년입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.a5,
        title = "라스베가스",
        description = "라스베가스입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.a6,
        title = "호르슈 밴드",
        description = "호르슈 밴드입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.a7,
        title = "미국의 길",
        description = "미국의 길입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.a8,
        title = "엔텔로프 캐년",
        description = "엔텔로프 캐년입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
    ItemData(
        imageId = R.drawable.a9,
        title = "그랜드 캐년",
        description = "그랜드 캐년입니다. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
    ),
)
