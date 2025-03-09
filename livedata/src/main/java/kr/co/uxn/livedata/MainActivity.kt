package kr.co.uxn.livedata

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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kr.co.uxn.livedata.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePracticeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    TopLevel()
                }
            }
        }
    }
}

class ToDoViewModel : ViewModel() {
    // 단계 2: text 상태를 라이브 데이터로 변경합니다.
    // 사용하는 측에서는 `text.observeAsState()`로 구독하세요.
//    val text = mutableStateOf("")
    private var _text = MutableLiveData("")
    val text: LiveData<String> = _text

    val setText: (String) -> Unit = {
        _text.value = it
    }


    // 단계 3: toDoList 상태를 라이브 데이터로 변경합니다.
    // 모든 연산에서 List를 새로 만들어 라이브 데이터로 전달해야 합니다!!!
    // (초 비추!!)

    private val _rawToDoList = mutableListOf<ToDoData>()
    private val _toDoList = MutableLiveData<List<ToDoData>>(_rawToDoList)
    val toDoList: LiveData<List<ToDoData>> = _toDoList

    // mutableStateListOf - 각 항목의 필드가 바뀌었을 때, 갱신이 안됨 그 외 추가, 삭제, 대입시 UI갱신 잘~ 됨
    // LiveData<List<X>>.observeAsState() - List가 아예 통채로 다른 List로 바뀌었을 때만 State가 갱신됨, 아주 심각한 새끼.
//    val toDoList = mutableStateListOf<ToDoData>()

    val onSubmit: (String) -> Unit = {
        val key = (_rawToDoList.lastOrNull()?.key ?: 0) + 1
//        toDoList.add(ToDoData(key, it))
        _rawToDoList.add(ToDoData(key, it))
//        _toDoList.value = ArrayList(_rawToDoList)
        _toDoList.value = _rawToDoList.toMutableList()
        // 위와 같은 효과. toMutableList가 새로운 ArrayList를 만들어내기에 위와 같다.
        _text.value = ""
    }

    val onEdit: (Int, String) -> Unit = { key, newText ->
//        val i = toDoList.indexOfFirst { it.key == key }
//        toDoList[i] = toDoList[i].copy(text = newText)

        val index = _rawToDoList.indexOfFirst { it.key == key }
        _rawToDoList[index] = _rawToDoList[index].copy(text = newText)
//        _toDoList.value = ArrayList(_rawToDoList)
        // 아래가 조금 더 빠르다.
        // shallow copy가 발생할 수 있다. (얕은 복사)
        _toDoList.value = mutableListOf<ToDoData>().also {
            it.addAll(_rawToDoList)
        }
    }

    val onToggle: (Int, Boolean) -> Unit = { key, checked ->
//        val i = toDoList.indexOfFirst { it.key == key }
//        toDoList[i] = toDoList[i].copy(done = checked)

        val index = _rawToDoList.indexOfFirst { it.key == key }
        _rawToDoList[index] = _rawToDoList[index].copy(done = checked)
        _toDoList.value = ArrayList(_rawToDoList)
    }

    val onDelete: (Int) -> Unit = { key ->
//        val i = toDoList.indexOfFirst { it.key == key }
//        toDoList.removeAt(i)
        val index = _rawToDoList.indexOfFirst { it.key == key }
        _rawToDoList.removeAt(index)
        _toDoList.value = ArrayList(_rawToDoList)
    }
}

@Composable
fun TopLevel(viewModel: ToDoViewModel = viewModel()) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            ToDoInput(
                text = viewModel.text.observeAsState("").value,
                // 기본값("")을 줬기에 null이 뜨지않는다. 그리고 observe를 하기에 라이브데이터가 바뀌면 반영이된다.
                onTextChange = {
//                    viewModel.text.value = it
                    viewModel.setText
                }, onSubmit = viewModel.onSubmit
            )
            val items = viewModel.toDoList.observeAsState(emptyList()).value
            LazyColumn {
                items(items = items, key = { it.key }) { toDoData ->
                    ToDo(
                        toDoData = toDoData,
                        onEdit = viewModel.onEdit,
                        onToggle = viewModel.onToggle,
                        onDelete = viewModel.onDelete
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
    text: String, onTextChange: (String) -> Unit, onSubmit: (String) -> Unit
) {
    Row(modifier = Modifier.padding(8.dp)) {
        OutlinedTextField(
            value = text, onValueChange = onTextChange, modifier = Modifier.weight(1f)
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

@Composable
fun ToDo(
    toDoData: ToDoData,
    onEdit: (key: Int, text: String) -> Unit = { _, _ -> },
    onToggle: (key: Int, checked: Boolean) -> Unit = { _, _ -> },
    onDelete: (key: Int) -> Unit = {}
) {
    var isEditing by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier.padding(4.dp), elevation =  CardDefaults.cardElevation(8.dp)
    ) {
        Crossfade(
            targetState = isEditing,
        ) {
            when (it) {
                false -> {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = toDoData.text, modifier = Modifier.weight(1f)
                        )
                        Text("완료")
                        Checkbox(checked = toDoData.done, onCheckedChange = { checked ->
                            onToggle(toDoData.key, checked)
                        })
                        Button(onClick = { isEditing = true }) {
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
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        val (text, setText) = remember { mutableStateOf(toDoData.text) }
                        OutlinedTextField(
                            value = text, onValueChange = setText, modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.size(8.dp))
                        Button(onClick = {
                            isEditing = false
                            onEdit(toDoData.key, text)
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
    val key: Int, val text: String, val done: Boolean = false
)