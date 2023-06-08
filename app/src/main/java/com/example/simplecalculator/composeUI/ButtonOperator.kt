package com.example.simplecalculator.composeUI


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
fun ButtonOperatorInterface(viewModel: ViewModelCalculator, fondColor: Color) {

    val fontsize = 35.sp


    Column(modifier = Modifier.fillMaxSize()
        .background(color = fondColor)) {
        Column() {
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(1f),
            ) {
                ButtonOperator("/",fontsize,viewModel)
            }
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(1f)
            ) {
                ButtonOperator("*",fontsize,viewModel)
            }
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(1f)
            ) {
                ButtonOperator("-",fontsize,viewModel)
            }
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(1f)
            ) {
                ButtonOperator("+",fontsize,viewModel)
            }
        }

    }
}