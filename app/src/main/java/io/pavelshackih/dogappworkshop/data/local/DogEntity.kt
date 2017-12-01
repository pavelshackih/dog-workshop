package io.pavelshackih.dogappworkshop.data.local

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "dogs")
data class DogEntity(
        @PrimaryKey(autoGenerate = true) var id: Int = 0,
        @ColumnInfo(name = "breed") var breed: String = "",
        @ColumnInfo(name = "image") var image: String = ""
)