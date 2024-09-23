package com.example.shoestap.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shoestap.model.Shoe

@Dao
interface ShoeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllShoes(shoes: List<Shoe>)

    @Query("SELECT * FROM shoes")
    suspend fun getAllShoes(): List<Shoe>
}