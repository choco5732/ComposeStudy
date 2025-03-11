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

@Composable
fun DetailScreen(
    pokemonId: Int,
    onButtonClick: () -> Unit,
    viewModel: PokemonViewModel
) {
    viewModel.getPokemon(pokemonId)
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
                        verticalAlignment = Alignment.CenterVertically,
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