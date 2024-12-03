package com.example.servinelectroreal.presentation.ui

import androidx.lifecycle.ViewModel
import com.example.servinelectroreal.domain.entity.GenreEntity
import com.example.servinelectroreal.domain.usecase.GetGenreEntityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MVIViewModel @Inject constructor(
    private val getGenreEntityUseCase: GetGenreEntityUseCase
) : ViewModel() {

    private val state = MVIState.Loading

    private val _stateFlow = MutableStateFlow<MVIState<Nothing>>(state)
    val stateFlow = _stateFlow.asStateFlow()


    suspend fun handelIntent(intent: MVIIntent) {
        when (intent) {
            MVIIntent.GetGenresList -> {
                getGenreEntityUseCase.getGenreEntity().collect {

                    if (it.size == 0) {
                        _stateFlow.emit(MVIState.Error)
                    } else {
                        _stateFlow.emit(MVIState.GenreEntity(it.get(0).name.toString()))
                    }


                }


            }


        }
    }
}

sealed class MVIState<out R>{
    data object Loading : MVIState<Nothing>()
    data object Error : MVIState<Nothing>()
    data class Success<out T>(val data: T) : MVIState<T>()
    data class GenreEntity(var result: String) : MVIState<Nothing>()
}

sealed class MVIIntent {
    data object GetGenresList : MVIIntent()
}


