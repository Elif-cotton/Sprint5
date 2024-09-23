package com.example.shoestap.respository

import com.example.shoestap.model.Shoe
import com.example.shoestap.room.ShoeDao
import javax.inject.Inject

class ShoeRepository @Inject constructor(private val shoeDao: ShoeDao) {

    // Método para insertar los zapatos en la base de datos
    suspend fun insertShoes(shoes: List<Shoe>) {
        shoeDao.insertAllShoes(shoes)
    }

    // Método para obtener todos los zapatos
    suspend fun getAllShoes(): List<Shoe> {
        return shoeDao.getAllShoes()
    }
}