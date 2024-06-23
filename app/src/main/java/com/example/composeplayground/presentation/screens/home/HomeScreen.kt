package com.example.composeplayground.presentation.screens.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen() {

    Scaffold(
        topBar = {
            HomeTopBar(onSearchClicked = {})
        }
    ) {

    }

}