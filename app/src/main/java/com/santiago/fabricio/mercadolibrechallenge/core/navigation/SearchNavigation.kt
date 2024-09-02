package com.santiago.fabricio.mercadolibrechallenge.core.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.santiago.fabricio.mercadolibrechallenge.features.presentation.screens.SearchScreen

const val searchScreenRoute = "searchScreenRoute"

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.searchScreen(
    navHostController: NavController
) {
    composable(searchScreenRoute) {
        SearchScreen(
            navigateToResults = { navHostController.navigateToResultsScreen() },
        )

    }
}

fun NavController.navigateToSearchScreen() {
    navigate(route = searchScreenRoute)
}