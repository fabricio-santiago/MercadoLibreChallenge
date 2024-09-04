package com.santiago.fabricio.mercadolibrechallenge.features.presentation.screens

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.santiago.fabricio.mercadolibrechallenge.R
import com.santiago.fabricio.mercadolibrechallenge.core.components.CustomAppBar
import com.santiago.fabricio.mercadolibrechallenge.core.components.EmptyDataScreen
import com.santiago.fabricio.mercadolibrechallenge.core.components.ErrorScreen
import com.santiago.fabricio.mercadolibrechallenge.core.components.LoadingScreen
import com.santiago.fabricio.mercadolibrechallenge.features.presentation.components.ResultsContent
import com.santiago.fabricio.mercadolibrechallenge.features.presentation.state.ResultsState

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ResultsScreen(
    uiState: ResultsState,
    navHostController: NavHostController,
    navigateToSearch: () -> Unit,
    retryRequest: () -> Unit,
) {
    Scaffold(topBar = {
        CustomAppBar(
            title = stringResource(id = R.string.results_screen_title_app_bar),
            showAppBarButton = true,
            onBackButtonClick = { navigateToSearch() }
        )
    },
    content = { paddingValues ->
        when (uiState) {
            is ResultsState.Loading -> {
                LoadingScreen()
            }

            is ResultsState.Error -> {
                ErrorScreen(
                    message = stringResource(id = R.string.results_content_error_message),
                    retry = { retryRequest() })
            }

            is ResultsState.EmptyData -> {
                EmptyDataScreen()
            }

            is ResultsState.SuccessUiState -> {
                ResultsContent(
                    navHostController = navHostController,
                    paddingValues = paddingValues,
                    results = uiState.results,
                )
            }
        }
    })
}