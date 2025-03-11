package kr.co.uxn.pokemon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreen(
    onPokemonClick: (String) -> Unit,
    viewModel: PokemonViewModel = hiltViewModel() // Navigation에 MainScreen이 소속되어 있으면, hiltViewModel을 써야만한다.
){
    val items = viewModel.pokemonList.collectAsLazyPagingItems()
    LazyColumn {
        items(items, key = { it.url }) {
            it?.let {
                Card(
                    elevation = 8.dp,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxSize()

                ) {
                    Row (
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Column {

                        }
                    }

                }
            }
        }
    }
}