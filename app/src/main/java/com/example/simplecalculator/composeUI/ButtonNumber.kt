package com.example.simplecalculator.composeUI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplecalculator.R
import com.example.simplecalculator.viewmodel.ViewModelCalculator


@Composable
fun ButtonNumberInterface(viewModel: ViewModelCalculator, fondColor: Color) {

    val fontsize = 35.sp

    Column(modifier = Modifier.fillMaxSize()
        .background(color = fondColor)) {
        Row(
            modifier = Modifier
                .weight(1f),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(1f),
            ) {
                ButtonNumber("7",fontsize,viewModel)
            }
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(1f)
            ) {
                ButtonNumber("8",fontsize,viewModel)
            }
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(1f)
            ) {
                ButtonNumber("9",fontsize,viewModel)
            }
        }
        Row(
            modifier = Modifier
                .weight(1f),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(1f),
            ) {
                ButtonNumber("4",fontsize,viewModel)
            }
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(1f)
            ) {
                ButtonNumber("5",fontsize,viewModel)
            }
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(1f)
            ) {
                ButtonNumber("6",fontsize,viewModel)
            }
        }
        Row(
            modifier = Modifier
                .weight(1f),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(1f),
            ) {
                ButtonNumber("1",fontsize,viewModel)
            }
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(1f)
            ) {
                ButtonNumber("2",fontsize,viewModel)
            }
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(1f)
            ) {
                ButtonNumber("3",fontsize,viewModel)
            }
        }
        Row(
            modifier = Modifier
                .weight(1f),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(1f),
            ) {
                ButtonNumber("0",fontsize,viewModel)
            }
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(1f)
            ) {
                ButtonNumber(".", fontsize, viewModel)
            }
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(1f)
            ) {
                ButtonNumber("+/-",fontsize,viewModel)
            }
        }
    }

}