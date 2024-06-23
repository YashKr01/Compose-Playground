package com.example.composeplayground.presentation.screens.home

import android.content.res.Configuration
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeplayground.R
import com.example.composeplayground.ui.theme.topAppBarBackgroundColor
import com.example.composeplayground.ui.theme.topAppBarContentColor

@Composable
fun HomeTopBar(onSearchClicked: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = "Explore",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            IconButton(onClick = onSearchClicked) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search)
                )
            }
        }
    )
}

@Composable
@Preview
fun HomeTopBarPreview() {
    HomeTopBar { }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun HomeTopBarDarkPreview() {
    HomeTopBar { }
}