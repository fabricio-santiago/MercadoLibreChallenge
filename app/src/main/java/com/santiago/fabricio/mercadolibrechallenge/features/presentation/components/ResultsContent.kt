package com.santiago.fabricio.mercadolibrechallenge.features.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.santiago.fabricio.mercadolibrechallenge.R

import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.SearchData

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ResultsContent(
    navHostController: NavController,
    paddingValues: PaddingValues,
    results: List<SearchData?>,
) {

    val context = LocalContext.current
    val modifier = Modifier

    Surface(modifier = modifier.background(MaterialTheme.colorScheme.background)) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            contentPadding = paddingValues,
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .clearAndSetSemantics {
                    contentDescription =
                        context.getString(R.string.results_content_description_lazy_vertical_grid)
                }
        ) {
            items(results.size) { index ->
                val searchData = results[index]
                searchData?.let { sd ->
                    LocationItem(
                        searchData = sd,
                        navHostController = navHostController,
                    )
                }
            }
        }
    }
}