package io.pavelshackih.dogappworkshop.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [(DogEntity::class)], version = 1)
abstract class DogsDb : RoomDatabase() {
    abstract fun dogsDao(): DogsDao
}