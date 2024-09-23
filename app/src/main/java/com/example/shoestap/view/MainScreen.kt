package com.example.shoestap.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoestap.components.ShoeCard
import com.example.shoestap.viewModel.ShoeViewModel


@ExperimentalMaterial3Api
@Composable
fun MainScreen(shoeViewModel: ShoeViewModel) {

    val shoes = shoeViewModel.shoes
    val sneakers = shoeViewModel.sneakers

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Shoes Tap", fontSize = 30.sp) })
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Text(text = "Zapatillas", fontSize = 28.sp, modifier = Modifier.padding(16.dp))

            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(sneakers.size) { index ->
                    ShoeCard(sneakers[index])
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Zapatos", fontSize = 28.sp, modifier = Modifier.padding(16.dp))

            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(shoes.size) { index ->
                    ShoeCard(shoes[index])
                }
            }
        }
    }
}