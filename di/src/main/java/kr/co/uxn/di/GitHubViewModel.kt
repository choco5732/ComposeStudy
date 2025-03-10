package kr.co.uxn.di

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// 메인액티비티에서 주입받기 위해서 @HiltViewModel 설정해준다.
@HiltViewModel
class GitHubViewModel @Inject constructor(
    private val githubService: GithubService
): ViewModel() {
    val repos = mutableStateListOf<Repo>()

    fun getRepos() {
        repos.clear()
        viewModelScope.launch {
            try {
                val data = githubService.listRepose("choco5732")
                repos.addAll(data)
            } catch (e: Exception) {
                Log.e("GitHubViewModel", "서버 통신 에러 : $e ")
            }
        }
    }
}