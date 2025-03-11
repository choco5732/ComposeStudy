package kr.co.uxn.pokemon

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val pokeAPI: PokeAPI
) : ViewModel() {
    private val _pokemonList = mutableStateListOf<Pokemon>()
    val pokemonList: List<Pokemon> = _pokemonList

    private fun getPokemons(): Flow<PagingData<Response.Result>> = Pager(
        config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = true
        ),
        paginSourceFactory = {
            object : PagingSource<Int, Response.Result>() {
                override fun getRefreshKey(state: PagingState<Int, Response.Result>): Int? {
                    return state.anchorPosition
                }

                override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Response.Result> {
                    try {
                        val pokemons = if (params.key != null) {
                            pokeAPI.getPokemons(params.key as Int, params.loadSize)
                        } else {
                            pokeAPI.getPokemons()
                        }
                        return LoadResult.Page(
                            data = pokemons.results,
                            prevKey = null,
                            nextKey = null
                        )
                    } catch (e: Exception) {
                        Log.e("EEE", "error : $e")
                        e.printStackTrace()
                        return LoadResult.Error(e)
                    }


                }
            }
        })
}


data class Pokemon(
    val name: String,
    val url: String
)