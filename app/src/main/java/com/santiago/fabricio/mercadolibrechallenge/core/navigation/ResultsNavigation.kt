package com.santiago.fabricio.mercadolibrechallenge.core.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.santiago.fabricio.mercadolibrechallenge.features.presentation.screens.ResultsScreen
import com.santiago.fabricio.mercadolibrechallenge.features.presentation.state.ResultsState

const val resultsScreenRoute = "resultsScreenRoute"

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.resultsScreen(
    navHostController: NavHostController,
    uiState: ResultsState
) {
    composable(route = resultsScreenRoute) {

        ResultsScreen(
            uiState = uiState,
            navHostController = navHostController,
            navigateToSearch = { navHostController.navigateToSearchScreen() },
        )
    }
}

fun NavController.navigateToResultsScreen() {
    navigate(route = resultsScreenRoute)
}

