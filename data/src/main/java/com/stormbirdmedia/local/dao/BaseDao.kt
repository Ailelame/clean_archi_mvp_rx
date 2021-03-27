package com.stormbirdmedia.local.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

interface BaseDao<T> {
    // Can be improved with list management
    @Insert
    fun insert(obj: T)

    @Insert
    fun insert(vararg obj: T)

    @Update
    fun update(obj: T)

    @Update
    fun update(entities: List<T>)

    @Delete
    fun delete(obj: T)
}