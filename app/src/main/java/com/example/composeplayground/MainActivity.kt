package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.navigation.SetupNavGraph
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalAnimationApi
@ExperimentalPagerApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}
