package com.santiago.fabricio.mercadolibrechallenge.core.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.santiago.fabricio.mercadolibrechallenge.features.presentation.screens.SearchScreen
import com.santiago.fabricio.mercadolibrechallenge.features.presentation.viewmodels.ResultsViewModel

const val searchScreenRoute = "searchScreenRoute"

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.searchScreen(
    navHostController: NavController,
    viewModel: ResultsViewModel,
) {
    composable(searchScreenRoute) {
        SearchScreen(
            navigateToResults = { navHostController.navigateToResultsScreen() },
            viewModel = viewModel,
            navHostController = navHostController
        )
    }
}

fun NavController.navigateToSearchScreen() {
    navigate(route = searchScreenRoute)
}