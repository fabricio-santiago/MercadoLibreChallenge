package com.santiago.fabricio.mercadolibrechallenge.features.presentation.screens

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.santiago.fabricio.mercadolibrechallenge.R
import com.santiago.fabricio.mercadolibrechallenge.core.components.CustomAppBar
import com.santiago.fabricio.mercadolibrechallenge.features.presentation.components.ResultsContent
import com.santiago.fabricio.mercadolibrechallenge.features.presentation.state.ResultsState

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ResultsScreen(
    uiState: ResultsState,
    navHostController: NavHostController,
    navigateToSearch: () -> Unit,
) {
    val results = uiState.results.collectAsLazyPagingItems()

    Scaffold(topBar = {
        CustomAppBar(
            title = stringResource(id = R.string.results_screen_title_app_bar),
            showAppBarButton = true,
            onBackButtonClick = { navigateToSearch() }
        )
    },
    content = { paddingValues ->
        ResultsContent(
            navHostController = navHostController,
            paddingValues = paddingValues,
            pagingResults = results,
        )
    })
}