package com.santiago.fabricio.mercadolibrechallenge.features.presentation.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.santiago.fabricio.mercadolibrechallenge.R
import com.santiago.fabricio.mercadolibrechallenge.core.components.CustomAppBar
import com.santiago.fabricio.mercadolibrechallenge.features.presentation.components.DetailContent
import com.santiago.fabricio.mercadolibrechallenge.features.presentation.state.ResultsState

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DetailScreen(
    uiState: ResultsState,
    index: Int,
    navigateToResults: () -> Unit,
) {

    Scaffold(
        topBar = {
            CustomAppBar(
                title = stringResource(id = R.string.details_screen_title_app_bar),
                showAppBarButton = true,
                onBackButtonClick = { navigateToResults() }
            )
        },
        content = { paddingValues ->
            DetailContent(
                uiState = uiState,
                index = index,
                paddingValues = paddingValues
            )
        })

}