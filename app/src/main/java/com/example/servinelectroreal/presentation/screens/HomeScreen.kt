package com.example.servinelectroreal.presentation.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.servinelectroreal.presentation.ui.MVIIntent
import com.example.servinelectroreal.presentation.ui.MVIState
import com.example.servinelectroreal.presentation.ui.MVIViewModel
import com.example.servinelectroreal.ui.theme.ServInElectroRealTheme

@Composable
fun Greeting(vm: MVIViewModel ) {
    val state = vm.stateFlow.collectAsState().value

    LaunchedEffect(Unit) {
        vm.handelIntent(MVIIntent.GetGenresList)
    }

    when(state){
        MVIState.Error -> Text("ERROR")
        is MVIState.GenreEntityState -> Text(state.genreEntity.first().name?:"Hallo")
        MVIState.Loading ->Text("Loading")
    }



}
