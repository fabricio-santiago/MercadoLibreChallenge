package com.santiago.fabricio.mercadolibrechallenge.core.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.santiago.fabricio.mercadolibrechallenge.features.presentation.screens.DetailScreen
import com.santiago.fabricio.mercadolibrechallenge.features.presentation.state.ResultsState

const val detailsScreenRoute = "detailsScreenRoute"
const val productArgument = "productArgument"

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.detailsScreen(
    navHostController: NavController,
    uiState: ResultsState
) {
    composable(route = "${detailsScreenRoute}/{$productArgument}",
        arguments = listOf(
            navArgument(productArgument) { type = NavType.IntType },
        )) { backStackEntry ->

        val product = backStackEntry.arguments?.getInt(productArgument)

        DetailScreen(
            uiState = uiState,
            index = product ?: 0,
            navigateToResults = { navHostController.navigateToResultsScreen() }
        )

    }
}

fun NavController.navigateToDetailScreen(productArgument: Int) {
    navigate(route = "${detailsScreenRoute}/$productArgument")
}