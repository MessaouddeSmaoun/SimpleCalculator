package com.example.simplecalculator.composeUI

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplecalculator.R
import com.example.simplecalculator.viewmodel.ViewModelCalculator


@Composable
fun ButtonNumber(txt: String = "1", fontsize: TextUnit = 20.sp, viewModel: ViewModelCalculator) {

    val backgroundColor = colorResource(id = R.color.backgroundColorNumber)
    val borderColor = colorResource(id = R.color.borderColorNumber)
    val textColor = colorResource(id = R.color.textColorNumber)

    Button(onClick = {
        if (txt == "." && viewModel.isPoint) return@Button
        else if (txt == ".") {
            viewModel.isPoint = true
            viewModel.setExpress(txt)
        } else {
            if (viewModel.expression == "0") viewModel.setExpress(txt)
            else viewModel.setExpress(txt)
            viewModel.isNumber = true

        }
        viewModel.isOperator = false
    }, modifier = Modifier
        .fillMaxSize()
        .border(5.dp, color = borderColor), colors = ButtonDefaults.buttonColors(backgroundColor)) {

        Text(
            text = txt,
            modifier = Modifier.padding(3.dp),
            fontSize = fontsize,
            color = textColor,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun ButtonOperator(txt: String = "+", fontsize: TextUnit = 20.sp, viewModel: ViewModelCalculator) {

    val backgroundColor = colorResource(id = R.color.backgroundColorOperator)
    val borderColor = colorResource(id = R.color.borderColorOperator)
    val textColor = colorResource(id = R.color.textColorOperator)

    Button(onClick = {

        if (viewModel.isOperator) viewModel.expression =
            viewModel.expression.substring(0, viewModel.expression.length - 1)

        viewModel.isOperator = true
        viewModel.isPoint = false
        viewModel.isNumber = false
        viewModel.setExpress(txt)
    }, modifier = Modifier
        .fillMaxSize()
        .border(5.dp, color = borderColor), colors = ButtonDefaults.buttonColors(backgroundColor)) {

        Text(
            text = txt,
            modifier = Modifier.padding(3.dp),
            fontSize = fontsize,
            color = textColor,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun ButtonMemo(txt: String = "MR", fontsize: TextUnit = 16.sp, viewModel: ViewModelCalculator) {

    val borderColor = colorResource(id = R.color.borderColorMemo)
    val backgroundColor = colorResource(id = R.color.backgroundColorMemo)
    val textColor = colorResource(id = R.color.textColorMemo)

    Button(onClick = {
        when (txt) {
            "MR" -> viewModel.setExpress(viewModel.memo)
            "MC" -> viewModel.memo = "0"
            "M+" -> viewModel.memo =
                (viewModel.memo.toDouble() + viewModel.expression.toDouble()).toString()

            "M-" -> viewModel.memo =
                (viewModel.memo.toDouble() - viewModel.expression.toDouble()).toString()
        }
    }, modifier = Modifier
        .fillMaxSize()
        .border(5.dp, color = borderColor), colors = ButtonDefaults.buttonColors(backgroundColor)) {

        Text(
            text = txt,
            modifier = Modifier.padding(3.dp),
            fontSize = fontsize,
            color = textColor,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun ButtonOperatorPlus(
    txt: String = "%",
    fontsize: TextUnit = 16.sp,
    viewModel: ViewModelCalculator
) {

    val borderColor = colorResource(id = R.color.borderColorOperatorSpec)
    val backgroundColor = colorResource(id = R.color.backgroundColorOperatorSpec)
    val textColor = colorResource(id = R.color.textColorOperatorSpec)

    Button(onClick = {
        viewModel.setExpress(txt)
    }, modifier = Modifier
        .fillMaxSize()
        .border(5.dp, color = borderColor), colors = ButtonDefaults.buttonColors(backgroundColor)) {

        Text(
            text = txt,
            modifier = Modifier.padding(3.dp),
            fontSize = fontsize,
            color = textColor,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun ButtonEgale(txt: String = "=", fontsize: TextUnit = 16.sp, viewModel: ViewModelCalculator) {


    val borderColor = colorResource(id = R.color.borderColorEqual)
    val backgroundColor = colorResource(id = R.color.backgroundColorEqual)
    val textColor = colorResource(id = R.color.textColorEqual)

    Button(onClick = {
        viewModel.egaleActualise()
    }, modifier = Modifier
        .fillMaxSize()
        .border(5.dp, color = borderColor), colors = ButtonDefaults.buttonColors(backgroundColor)) {

        Text(
            text = txt,
            modifier = Modifier.padding(3.dp),
            fontSize = fontsize,
            color = textColor,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ButtonMenu(txt: String = "Me", fontsize: TextUnit = 20.sp, viewModel: ViewModelCalculator) {

    val borderColor = colorResource(id = R.color.borderColorRemove)
    val backgroundColor = colorResource(id = R.color.backgroundColorRemove)
    val textColor = colorResource(id = R.color.textColorRemove)

    Button(onClick = {
        when (txt) {
            "AC" -> viewModel.setExpress("0")
            "Del" -> {
                if (viewModel.expression.length == 1) viewModel.setExpress("0")
                else viewModel.setExpressionDel()
            }
        }
    }, modifier = Modifier
        .fillMaxSize()
        .border(5.dp, color = borderColor), colors = ButtonDefaults.buttonColors(backgroundColor)) {

        Text(
            text = txt,
            modifier = Modifier.padding(3.dp),
            fontSize = fontsize,
            color = textColor,
            textAlign = TextAlign.Center
        )
    }
}