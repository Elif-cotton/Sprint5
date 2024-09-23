package com.example.shoestap.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.shoestap.model.Shoe

@Database(entities = [Shoe::class], version = 1)
abstract class ShoeDatabase : RoomDatabase() {
    abstract fun shoeDao(): ShoeDao
}