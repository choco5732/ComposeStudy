package kr.co.uxn.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontVariation.weight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.uxn.todo.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePracticeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopLevel()
                }
            }
        }
    }
}

@Composable
fun TopLevel() {
    var (text, setText) = remember { mutableStateOf("") }
    val toDoList = remember { mutableStateListOf<ToDoData>() }
    // mutableStateList는 항목이 추가되거나 삭제 혹은 항목이 바뀌면 리컴포지션 된다.
    // 즉, 항목 필드 값만 바꾸면 Compose가 내부 값 변화를 감지하지 않는다.
    // 따라서 copy를 이용해 새 항목을 넣어주면 리콤포지션이 가능하다.
    val onSubmit: (String) -> Unit = {
        val key = (toDoList.lastOrNull()?.key ?: 0) + 1
        toDoList.add(ToDoData(key, text))
        setText("")
    }

    val onToggle: (Int, Boolean) -> Unit = { key, checked ->
        val index = toDoList.indexOfFirst { it.key == key }
        toDoList[index] = toDoList[index].copy(done = checked)
    }

    val onDelete: (Int) -> Unit = { key ->
        val index = toDoList.indexOfFirst { it.key == key }
        toDoList.removeAt(index)
    }

    val onEdit: (Int, String) -> Unit = { key, text ->
        val index = toDoList.indexOfFirst { it.key == key }
        toDoList[index] = toDoList[index].copy(text = text)
    }
    // 단계 4: `onSubmit`, `onEdit`, `onToggle`, `onDelete`를
    // 만들어 `ToDo`에 연결합니다.

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            ToDoInput(
                text = text,
                onTextChange = setText,
                onSubmit = onSubmit
            )
            // 단계 3: `LazyColumn`으로 `toDoList`를 표시합시다.
            // `key`를 `toDoData`의 `key`를 사용합니다.
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp)
            ) {
                // key를 주면, Compose에서 리콤포지션으르 효율적으로 처리할 수 있다.
                items(toDoList, key = {it.key}) { todoData ->
//                    Text(text = todoData.text)
                    ToDo(
                        toDoData = todoData,
                        onDelete = onDelete,
                        onToggle = onToggle,
                        onEdit = onEdit
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeTheme {
        TopLevel()
    }
}

@Composable
fun ToDoInput(
    text: String,
    onTextChange: (String) -> Unit,
    onSubmit: (String) -> Unit
) {
    Row(modifier = Modifier.padding(8.dp)) {
        OutlinedTextField(
            value = text,
            onValueChange = onTextChange,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.size(8.dp))
        Button(onClick = {
            onSubmit(text)
        }) {
            Text("입력")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoInputPreview() {
    ComposePracticeTheme {
        ToDoInput("테스트", {}, {})
    }
}

// done, 1,
@Composable
fun ToDo(
    toDoData: ToDoData,
    onEdit: (key: Int, text: String) -> Unit = { _, _ -> },
    onToggle: (key: Int, checked: Boolean) -> Unit = { _, _ -> },
    onDelete: (key: Int) -> Unit = {}
) {
    var isEditing by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .padding(3.dp)
            .shadow(3.dp),
//        elevation = CardDefaults.elevatedCardElevation(8.dp)
    ) {
        // 단계 2: `Crossfade`를 통해 `isEditing`을 따라 다른
        // UI를 보여줍니다. `OutlinedTextField`와 `Button을
        // 넣어봅시다.
        Crossfade(targetState = isEditing) {
            when (it) {
                false -> {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(
                            text = toDoData.text,
                            modifier = Modifier.weight(1f)
                        )
                        Text(text = "완료")
                        Checkbox(
                            checked = toDoData.done,
                            onCheckedChange = { checked ->
                                onToggle(
                                    toDoData.key,
                                    checked
                                ) // onCheckChange는 Boolean -> Unit이라, onToggle을 바로쓰지않고, 형식에 맞춰줌
                            }
                        )
                        Button(onClick = {
                            isEditing = true
                        }) {
                            Text("수정")
                        }
                        Spacer(modifier = Modifier.size(4.dp))
                        Button(onClick = { onDelete(toDoData.key) }) {
                            Text("삭제")
                        }
                    }
                }

                true -> {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        OutlinedTextField(
                            value = toDoData.text,
                            onValueChange = {
                                onEdit(toDoData.key, it)
                            },
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Button(onClick = {
                            isEditing = false
                        }) {
                            Text("완료")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoPreview() {
    ComposePracticeTheme {
        ToDo(ToDoData(1, "nice", true))
    }
}

data class ToDoData(
    val key: Int,
    val text: String,
    val done: Boolean = false
)