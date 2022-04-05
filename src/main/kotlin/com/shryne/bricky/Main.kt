package com.shryne.bricky

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.ComposeDialog
import androidx.compose.ui.graphics.Color
import com.shryne.bricky.api.parameter.Color as BColor
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.shryne.bricky.api.CatalogSearch
import com.shryne.bricky.api.Condition
import com.shryne.bricky.api.Country

@Composable
fun TableText(text: String) =
    Text(
        text = text,
        modifier = Modifier
            .padding(2.dp)
            .background(Color.Red)
            .width(150.dp)
            .height(20.dp),
        textAlign = TextAlign.Center,
        color = Color.White,
    )


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        setupUnirest()
        val catalog1 =
            CatalogSearch(381, BColor.BLACK, Country.DE, Country.DE, Condition.NEW)

        var isDialogOpen by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxSize(), Arrangement.spacedBy(5.dp)) {
            Row {
                TableText("Part")
                TableText("Price")
                TableText("Number of stores")
            }
            (0..3).forEachIndexed { index, i ->
                Row {
                    TableText("1x1 plate black")
                    TableText(catalog1.catalog().findings!![0].mInvSalePrice)
                    TableText(catalog1.catalog().findings!!.size.toString())
                    // Divider(color = Color.Black, thickness = 2.dp)
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                OutlinedButton(
                    onClick = { isDialogOpen = true }
                ) {
                    Text("+")
                }
            }
        }

        if (isDialogOpen) {
            Dialog(
                create = {
                    ComposeDialog()
                },
                dispose = { isDialogOpen = false }
            ) {
                Text("Hey")
            }
        }
    }
}
