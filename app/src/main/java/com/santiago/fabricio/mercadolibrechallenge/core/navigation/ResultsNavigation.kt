package com.santiago.fabricio.mercadolibrechallenge.core.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.santiago.fabricio.mercadolibrechallenge.features.presentation.screens.ResultsScreen
import com.santiago.fabricio.mercadolibrechallenge.features.presentation.viewmodels.ResultsViewModel

const val resultsScreenRoute = "resultsScreenRoute"

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.resultsScreen(
    navHostController: NavHostController,
    viewModel: ResultsViewModel,
) {
    composable(route = resultsScreenRoute) {
        val uiState by viewModel.uiState.collectAsState()

        val searchText: String? = navHostController.previousBackStackEntry?.savedStateHandle?.get("searchText")

        ResultsScreen(
            uiState = uiState,
            navHostController = navHostController,
            navigateToSearch = { navHostController.navigateToSearchScreen() },
            retryRequest = { viewModel.getResults(searchText ?: "") }
        )
    }
}

fun NavController.navigateToResultsScreen() {
    navigate(route = resultsScreenRoute)
}

