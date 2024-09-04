package com.santiago.fabricio.mercadolibrechallenge.features.presentation.screens

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.santiago.fabricio.mercadolibrechallenge.features.presentation.components.SearchContent
import com.santiago.fabricio.mercadolibrechallenge.features.presentation.viewmodels.ResultsViewModel

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchScreen(
    navigateToResults: () -> Unit,
    viewModel: ResultsViewModel,
    navHostController: NavController,
) {
    Scaffold(
        content = {
            SearchContent(
                navigateToResults = navigateToResults,
                viewModel = viewModel,
                navHostController = navHostController
            )
        }
    )
}