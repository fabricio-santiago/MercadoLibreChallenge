package com.santiago.fabricio.mercadolibrechallenge.core.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.google.gson.Gson
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.Installments
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.SearchData
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.Seller
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.Shipping
import com.santiago.fabricio.mercadolibrechallenge.features.presentation.screens.DetailScreen

const val detailsScreenRoute = "detailsScreenRoute"

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.detailsScreen(
    navHostController: NavController,
) {
    composable(route = detailsScreenRoute){

        val product: String? = navHostController.previousBackStackEntry?.savedStateHandle?.get("product")

        val searchData: SearchData = try {
            Gson().fromJson(product, SearchData::class.java)
        }catch (e: Exception) {
            SearchData()
        }

        DetailScreen(
            searchData = searchData,
            navigateToResults = { navHostController.navigateToResultsScreen() }
        )

    }
}

fun NavController.navigateToDetailScreen() {
    navigate(route = detailsScreenRoute)
}