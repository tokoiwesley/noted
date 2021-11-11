package com.xfactor.noted.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class List(
    @PrimaryKey val uId: Int,
    @ColumnInfo(name = "title") val title: String
)
