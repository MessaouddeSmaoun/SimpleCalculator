package com.example.simplecalculator.composeUI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplecalculator.R
import com.example.simplecalculator.viewmodel.ViewModelCalculator


@Composable
fun ButtonOperatorPlusInterface(viewModel: ViewModelCalculator, fondColor: Color) {

    val fontsize = 14.sp

    Row(modifier = Modifier.fillMaxSize()
        .background(color = fondColor)) {
        Box(
            modifier = Modifier
                .padding(5.dp)
                .weight(1f),
        ) {
            ButtonOperatorPlus("%", fontsize,viewModel)
        }
        Box(
            modifier = Modifier
                .padding(5.dp)
                .weight(1f)
        ) {
            ButtonOperatorPlus("^", fontsize,viewModel)
        }
        Box(
            modifier = Modifier
                .padding(5.dp)
                .weight(1f)
        ) {
            ButtonOperatorPlus("|", fontsize,viewModel)
        }
    }
}