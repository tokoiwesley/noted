package com.xfactor.noted.database

import androidx.room.*

@Dao
interface ListItemDao {
    @Query("SELECT * FROM list_item")
    fun getAll(): kotlin.collections.List<ListItem>

    @Insert
    fun insertAll(vararg listItem: ListItem)

    @Delete
    fun delete(listItem: ListItem)
}
