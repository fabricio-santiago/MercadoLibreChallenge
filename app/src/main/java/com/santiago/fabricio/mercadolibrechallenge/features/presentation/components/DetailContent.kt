package com.santiago.fabricio.mercadolibrechallenge.features.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.santiago.fabricio.mercadolibrechallenge.R
import com.santiago.fabricio.mercadolibrechallenge.core.components.AsyncAvatarImage
import com.santiago.fabricio.mercadolibrechallenge.features.presentation.state.ResultsState


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DetailContent(
    uiState: ResultsState,
    index: Int,
    paddingValues: PaddingValues
) {

    val context = LocalContext.current
    val results = uiState.results.collectAsLazyPagingItems()
    val modifier = Modifier

    val product = results[index]
    Surface(modifier = modifier.background(MaterialTheme.colorScheme.background)) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
        AsyncAvatarImage(
            dataUrl = product?.thumbnail ?: "",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clearAndSetSemantics {
                    contentDescription =
                        context.getString(R.string.characters_item_description_avatar_image)
                },
            size = 300,
            padding = 82
        )
//            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = product?.title ?: "",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.clearAndSetSemantics {
                        contentDescription =
                            context.getString(R.string.locations_item_description_name)
                    }
                )

                Spacer(modifier = Modifier.size(8.dp))

                Text(
                    text = String.format("Preço: R$ %s", product?.price),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.clearAndSetSemantics {
                        contentDescription =
                            context.getString(R.string.locations_item_description_type)
                    },
                )

                Spacer(modifier = Modifier.size(8.dp))

                Text(
                    text = String.format("Quantidade %s", product?.availableQuantity),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.clearAndSetSemantics {
                        contentDescription =
                            context.getString(R.string.locations_item_description_type)
                    },
                )

                Spacer(modifier = Modifier.size(8.dp))

                Text(
                    text = String.format("Aceita mercado pago? %s", product?.acceptsMercadopago),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.clearAndSetSemantics {
                        contentDescription =
                            context.getString(R.string.locations_item_description_type)
                    },
            )

            Spacer(modifier = Modifier.size(8.dp))

            Text(
                text = String.format("Vendido por: %s", product?.seller?.nickname),
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.clearAndSetSemantics {
                    contentDescription =
                        context.getString(R.string.locations_item_description_type)
                },
            )

            Spacer(modifier = Modifier.size(8.dp))

            Text(
                text = String.format("Frete grátis?: %s", product?.shipping?.freeShipping),
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.clearAndSetSemantics {
                    contentDescription =
                        context.getString(R.string.locations_item_description_type)
                },
            )

            Spacer(modifier = Modifier.size(8.dp))

            Text(
                text = String.format("Classificação: %s", product?.installments?.rate),
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.clearAndSetSemantics {
                    contentDescription =
                        context.getString(R.string.locations_item_description_type)
                },
            )
//            }
        }

    }
}