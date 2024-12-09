package com.example.servinelectroreal.presentation.ui

import androidx.lifecycle.ViewModel
import com.example.servinelectroreal.domain.entity.GenreEntity
import com.example.servinelectroreal.domain.usecase.GetGenreEntityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MVIViewModel @Inject constructor(
    private val getGenreEntityUseCase: GetGenreEntityUseCase
) : ViewModel() {

    private val state = MVIState.Loading

    private val _stateFlow = MutableStateFlow<MVIState>(state)
    val stateFlow = _stateFlow.asStateFlow()


    suspend fun handelIntent(intent: MVIIntent) {
        when (intent) {
            MVIIntent.GetGenresList -> {
                getGenreEntityUseCase.getGenreEntity().collect {
                    _stateFlow.emit(MVIState.GenreEntityState(it))
                }

            }
        }
    }
}

sealed class MVIState {
    data object Loading : MVIState()
    data object Error : MVIState()
    data class GenreEntityState(val genreEntity: List<GenreEntity>) : MVIState()
}

sealed class MVIIntent {
    data object GetGenresList : MVIIntent()
}


