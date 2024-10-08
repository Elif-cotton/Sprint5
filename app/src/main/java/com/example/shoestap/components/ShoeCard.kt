package com.example.shoestap.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.shoestap.model.Shoe
@Composable
fun ShoeCard(shoe: Shoe) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(180.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Center the content
            modifier = Modifier.padding(5.dp) // Padding around the entire column
        ) {
            Image(
                painter = rememberAsyncImagePainter(shoe.imageUrl),
                contentDescription = shoe.name,
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = shoe.name,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold), // Make the text bold
                modifier = Modifier.padding(5.dp), // Padding around the text
                textAlign = TextAlign.Center // Center text horizontally
            )
            Text(
                text = shoe.formattedPrice,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(5.dp), // Padding around the price text
                textAlign = TextAlign.Center // Center text horizontally
            )
        }
    }
}
