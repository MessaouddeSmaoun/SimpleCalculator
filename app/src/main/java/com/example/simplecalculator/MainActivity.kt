package com.example.simplecalculator

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.simplecalculator.composeUI.*
import com.example.simplecalculator.ui.theme.SimpleCalculatorTheme
import com.example.simplecalculator.viewmodel.ViewModelCalculator
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    val viewModel by viewModels<ViewModelCalculator>()
    private var expre = "1+2"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.expressionFlow.collect {
                    expre = it
                    Log.d("expression", "expression : $expre")

                }
            }
        }

        setContent {
            SimpleCalculatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.colorBackground)
                ) {
                    Greeting(viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(viewModel: ViewModelCalculator) {

    val fondColor = colorResource(id = R.color.colorBackground)



    Column(Modifier.fillMaxSize()
        .background(color = Color.Red)) {

        Surface(modifier = Modifier.weight(1.7f)
            .background(color = Color.Green)) {
            DisplayScreenInterface(viewModel,fondColor)
        }

        Surface(modifier = Modifier.weight(0.7f)) {
            ButtonMemoInterface(viewModel, fondColor)
        }

        Surface(modifier = Modifier.weight(1f)
            .background(color = Color.Yellow)) {
            ButtonMenInterface(viewModel, fondColor)
        }
        Row(Modifier.weight(5f)) {
            Column(Modifier.weight(3f)) {
                Surface(modifier = Modifier.weight(1f)) {
                    ButtonOperatorPlusInterface(viewModel, fondColor)
                }
                Surface(modifier = Modifier.weight(4f)) {
                    ButtonNumberInterface(viewModel, fondColor)
                }
            }
            Column(Modifier.weight(1f)) {
                Surface(modifier = Modifier.weight(4f)) {
                    ButtonOperatorInterface(viewModel, fondColor)
                }
                Surface(modifier = Modifier.weight(1f)) {
                    ButtonEgaleInterface(viewModel, fondColor)
                }
            }
        }

    }
}

