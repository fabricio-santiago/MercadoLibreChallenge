package com.santiago.fabricio.mercadolibrechallenge.features.presentation.screens

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.santiago.fabricio.mercadolibrechallenge.features.presentation.components.SearchContent

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchScreen(
    navigateToResults: () -> Unit,
) {
    Scaffold(
        content = {
            SearchContent(
                modifier = Modifier,
                navigateToResults = navigateToResults
            )
        }
    )
}