package com.xfactor.noted

import com.xfactor.noted.database.ListWithListItems

data class ListItem(
    val id: Long,
    var title: String,
    val elements: MutableList<String>
)

val Lists = mutableListOf(
    ListItem(0, "List 1", elements = mutableListOf("Element 1", "Element 2")),
    ListItem(1, "List 2", elements = mutableListOf("Element 1", "Element 2")),
    ListItem(2, "List 3", elements = mutableListOf("Element 1", "Element 2"))
)


val ListsToCompare = mutableListOf<ListItem>()

fun getLists(): ListWithListItems {
    return appDatabase.listDao.getListWithListItems()
}


fun getSubItems(item: ListItem): String {
    val inListForm =
        item.elements.mapIndexed { idx, value -> (idx + 1).toString().plus(". ").plus(value) }
    return inListForm.joinToString("\n")
}
