package com.example.shoestap.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoestap.model.Shoe
import com.example.shoestap.model.formatPriceClp
import com.example.shoestap.respository.ShoeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoeViewModel @Inject constructor(private val repository: ShoeRepository) : ViewModel() {

    val shoes = listOf(
        Shoe("1", "Zapato azul", "https://imagedelivery.net/4fYuQyy-r8_rpBpcY7lH_A/falabellaCL/6540401_01/w=1500,h=1500,fit=pad", 49990, formatPriceClp(49990), "Elegante zapato de cuero color azul."),
        Shoe("2", "Zapato Casual", "https://imagedelivery.net/4fYuQyy-r8_rpBpcY7lH_A/falabellaCL/14536403_01/w=1500,h=1500,fit=pad", 34990, formatPriceClp(34990), "Zapato casual para uso diario, cómodo y resistente."),
        Shoe("3", "Botín Café", "https://imagedelivery.net/4fYuQyy-r8_rpBpcY7lH_A/falabellaCL/8415865_1/w=1500,h=1500,fit=pad", 79990, formatPriceClp(79990), "Botín de cuero café, ideal para invierno."),
        Shoe("4", "Sandalia café", "https://imagedelivery.net/4fYuQyy-r8_rpBpcY7lH_A/falabellaCL/6540473_1/w=1500,h=1500,fit=pad", 39990, formatPriceClp(39990), "Sandalia cómoda de color café para verano."),
        Shoe("5", "Sandalia negra", "https://imagedelivery.net/4fYuQyy-r8_rpBpcY7lH_A/falabellaCL/50280586_01/w=1500,h=1500,fit=pad", 29990, formatPriceClp(29990), "Elegante sandalia negra, ideal para ocasiones especiales."),
        Shoe("6", "Zapato Vancouver", "https://imagedelivery.net/4fYuQyy-r8_rpBpcY7lH_A/falabellaCL/132195819_01/w=1500,h=1500,fit=pad", 64990, formatPriceClp(64990), "Zapato Vancouver en cuero marrón, estilo formal.")
    )

    val sneakers = listOf(
        Shoe("7", "Converse plataforma", "https://imagedelivery.net/4fYuQyy-r8_rpBpcY7lH_A/falabellaCL/16425329_01/w=1500,h=1500,fit=pad", 9990, formatPriceClp(9990), "Zapatillas Converse de plataforma, moda y comodidad."),
        Shoe("8", "Converse plana", "https://imagedelivery.net/4fYuQyy-r8_rpBpcY7lH_A/falabellaCL/50039260_01/w=1500,h=1500,fit=pad", 7990, formatPriceClp(7990), "Zapatillas Converse de suela plana, clásico y resistente."),
        Shoe("9", "All Star", "https://imagedelivery.net/4fYuQyy-r8_rpBpcY7lH_A/falabellaCL/50036478_01/w=1500,h=1500,fit=pad", 14990, formatPriceClp(14990), "Zapatillas All Star para uso casual, estilo juvenil."),
        Shoe("10", "All Star plana", "https://imagedelivery.net/4fYuQyy-r8_rpBpcY7lH_A/falabellaCL/4256777_01/w=1500,h=1500,fit=pad", 12990, formatPriceClp(12990), "Zapatillas All Star con suela plana, perfectas para el día a día."),
        Shoe("11", "Converse tradicional", "https://imagedelivery.net/4fYuQyy-r8_rpBpcY7lH_A/falabellaCL/15077532_01/w=1500,h=1500,fit=pad", 10990, formatPriceClp(10990), "Converse tradicional, diseño clásico y versátil."),
        Shoe("12", "Converse Caña", "https://imagedelivery.net/4fYuQyy-r8_rpBpcY7lH_A/falabellaCL/16425336_01/w=800,h=800,fit=pad", 8990, formatPriceClp(8990), "Converse caña alta, ideal para un look más atrevido.")
    )

    init {
        insertShoes() // función al inicializar el ViewModel
    }

    fun insertShoes() {
        viewModelScope.launch {
            try {
                repository.insertShoes(shoes + sneakers)
            } catch (e: Exception) {
                Log.e("ShoeViewModel", "Error inserting shoes", e)
            }
        }
    }
}
