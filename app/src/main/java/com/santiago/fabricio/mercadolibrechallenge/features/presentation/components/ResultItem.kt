package com.santiago.fabricio.mercadolibrechallenge.features.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.gson.Gson
import com.santiago.fabricio.mercadolibrechallenge.R
import com.santiago.fabricio.mercadolibrechallenge.core.components.AsyncAvatarImage
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.SearchData
import com.santiago.fabricio.mercadolibrechallenge.core.navigation.navigateToDetailScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LocationItem(
    searchData: SearchData,
    navHostController: NavController,
) {
    val context = LocalContext.current

    OutlinedCard(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable {
                navHostController.currentBackStackEntry?.savedStateHandle?.set("product", Gson().toJson(searchData))
                navHostController.navigateToDetailScreen()
            }
            .clearAndSetSemantics {
                contentDescription =
                    context.getString(R.string.result_item_description_outlined_card)
            },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            AsyncAvatarImage(
                dataUrl = searchData.thumbnail,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .clearAndSetSemantics {
                        contentDescription =
                            context.getString(R.string.result_item_image)
                    },
                size = 80,
                verticalPadding = 12,
                horizontalPadding = 12,
            )
            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = searchData.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.clearAndSetSemantics {
                        contentDescription =
                            context.getString(R.string.result_item_description)
                    }
                )

                Spacer(modifier = Modifier.size(8.dp))

                Text(
                    text = String.format("Preço: R$ %s", searchData.price),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.clearAndSetSemantics {
                        contentDescription =
                            context.getString(R.string.result_item_price)
                    },
                )
            }
        }
    }
}