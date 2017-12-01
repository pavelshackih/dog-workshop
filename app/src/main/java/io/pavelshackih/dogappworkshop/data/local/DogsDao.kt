package io.pavelshackih.dogappworkshop.data.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Single

@Dao
interface DogsDao {

    @Query("select * from dogs")
    fun findAll(): Single<List<DogEntity>>

    @Insert
    fun save(entity: DogEntity): Long

    @Delete
    fun delete(entity: DogEntity): Int

    @Query("delete from dogs")
    fun delete(): Int
}