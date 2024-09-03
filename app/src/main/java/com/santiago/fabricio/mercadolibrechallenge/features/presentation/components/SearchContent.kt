package com.santiago.fabricio.mercadolibrechallenge.features.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.santiago.fabricio.mercadolibrechallenge.R
import com.santiago.fabricio.mercadolibrechallenge.theme.yellow

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SearchContent(
    navigateToResults: () -> Unit,
) {
    var text by rememberSaveable { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp)
            .fillMaxSize(),
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(stringResource(id = R.string.search_label)) }
        )

        Spacer(modifier = Modifier.size(32.dp))

        Button(onClick = navigateToResults, colors = ButtonDefaults.buttonColors(yellow)) {
            Text(
                text = stringResource(R.string.search_button_text),
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}