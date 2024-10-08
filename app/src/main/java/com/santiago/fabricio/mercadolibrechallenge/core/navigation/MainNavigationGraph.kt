package com.santiago.fabricio.mercadolibrechallenge.core.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.santiago.fabricio.mercadolibrechallenge.features.presentation.viewmodels.ResultsViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainNavigationGraph(
    navHostController: NavHostController
) {
    val viewModel: ResultsViewModel = hiltViewModel<ResultsViewModel>()

    NavHost(
        navController = navHostController,
        startDestination = searchScreenRoute,
    ) {
        searchScreen(navHostController = navHostController, viewModel = viewModel)
        resultsScreen(navHostController = navHostController, viewModel = viewModel)
        detailsScreen(navHostController = navHostController)
    }
}