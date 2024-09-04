package com.santiago.fabricio.mercadolibrechallenge.features.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.unit.dp
import com.santiago.fabricio.mercadolibrechallenge.R
import com.santiago.fabricio.mercadolibrechallenge.core.components.AsyncAvatarImage
import com.santiago.fabricio.mercadolibrechallenge.core.data.remote.model.SearchData
import com.santiago.fabricio.mercadolibrechallenge.core.util.UtilFunctions.formatDateAPI

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DetailContent(
    searchData: SearchData?,
    paddingValues: PaddingValues
) {

    val context = LocalContext.current
    val modifier = Modifier

    Surface(modifier = modifier.background(MaterialTheme.colorScheme.background)) {

        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 24.dp)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        ) {
            AsyncAvatarImage(
                dataUrl = searchData?.thumbnail ?: "",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clearAndSetSemantics {
                        contentDescription =
                            context.getString(R.string.details_content_image)
                    },
                size = 250,
                verticalPadding = 56,
                horizontalPadding = 16
            )
            Text(
                text = searchData?.title ?: "",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.clearAndSetSemantics {
                    contentDescription =
                        context.getString(R.string.details_content_description)
                }
            )

            Spacer(modifier = Modifier.size(32.dp))

            Text(
                text = String.format("Preço: R$ %s", searchData?.price),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.clearAndSetSemantics {
                    contentDescription =
                        context.getString(R.string.details_content_price)
                },
            )

            Spacer(modifier = Modifier.size(8.dp))

            Text(
                text = String.format("Quantidade: %s", searchData?.availableQuantity),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.clearAndSetSemantics {
                    contentDescription =
                        context.getString(R.string.details_content_quantity)
                },
            )

            Spacer(modifier = Modifier.size(8.dp))

            Text(
                text = String.format("Aceita mercado pago?: %s", (if (searchData?.acceptsMercadopago == true)  "Sim" else "Não")),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.clearAndSetSemantics {
                    contentDescription =
                        context.getString(R.string.details_content_accept_mp)
                },
            )

            Spacer(modifier = Modifier.size(8.dp))

            Text(
                text = String.format("Vendido por: %s", searchData?.seller?.nickname),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.clearAndSetSemantics {
                    contentDescription =
                        context.getString(R.string.details_content_seller_name)
                },
            )

            Spacer(modifier = Modifier.size(8.dp))

            Text(
                text = String.format("Frete grátis?: %s", if (searchData?.shipping?.freeShipping == true)  "Sim" else "Não"),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.clearAndSetSemantics {
                    contentDescription =
                        context.getString(R.string.details_content_free_shipping)
                },
            )

            Spacer(modifier = Modifier.size(8.dp))

            Text(
                text = String.format("Classificação: %s", searchData?.installments?.rate),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.clearAndSetSemantics {
                    contentDescription =
                        context.getString(R.string.details_content_rate)
                },
            )

            Spacer(modifier = Modifier.size(8.dp))

            Text(
                text = String.format("Data limite: %s", searchData?.stopTime?.formatDateAPI()),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.clearAndSetSemantics {
                    contentDescription =
                        context.getString(R.string.details_content_date)
                },
            )
        }
    }
}