package com.xfactor.noted.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

@Entity
data class ListWithListItems(
    @Embedded val list: List,
    @Relation(
        parentColumn = "uId",
        entityColumn = "listId"
    )
    val listItems: kotlin.collections.List<ListItem>
)
