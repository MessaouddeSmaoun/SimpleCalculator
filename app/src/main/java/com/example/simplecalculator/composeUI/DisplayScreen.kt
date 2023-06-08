package com.example.simplecalculator.composeUI


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplecalculator.R
import com.example.simplecalculator.viewmodel.ViewModelCalculator
import kotlinx.coroutines.flow.collect


@Composable
fun DisplayScreenInterface(viewModel: ViewModelCalculator, fondColor: Color ) {


    val expression by viewModel.expressionFlow.collectAsState("0")


    val backgroundColor = colorResource(id = R.color.backgroundColorDisplay)
    val textColor = colorResource(id = R.color.numberColorDisplay)

    val marge = 10.dp



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = fondColor)
            .padding(marge)
            .background(color = backgroundColor, shape = RoundedCornerShape(10.dp))
            .padding(horizontal = marge),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        Text(
            text = expression,
            Modifier.fillMaxWidth(),
            fontSize = 22.sp,
            textAlign = TextAlign.Start,
            maxLines = 1,
            color = textColor,
        )
        Text(
            text = expression,
            Modifier.fillMaxWidth(),
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End,
            maxLines = 1,
            color = textColor
        )

        Image(
            modifier = Modifier
                .fillMaxSize()
                .align(CenterHorizontally),
            painter = painterResource(id = R.drawable.arrow_down),
            contentDescription = "etension",
        )
    }

}