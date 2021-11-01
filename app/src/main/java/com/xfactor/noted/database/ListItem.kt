package com.xfactor.noted.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "list_item")
data class ListItem(
    @PrimaryKey val uid: Int,
    val listId: Int,
    val value: String
)
