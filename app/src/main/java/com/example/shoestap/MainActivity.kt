package com.example.shoestap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import dagger.hilt.android.AndroidEntryPoint
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shoestap.view.MainScreen
import com.example.shoestap.viewModel.ShoeViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val shoeViewModel: ShoeViewModel by viewModels()

    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(shoeViewModel)
        }
    }
}