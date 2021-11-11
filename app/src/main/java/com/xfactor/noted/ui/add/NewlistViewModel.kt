package com.xfactor.noted.ui.add

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xfactor.noted.database.ListItem
import com.xfactor.noted.database.ListWithListItems
import com.xfactor.noted.getListItems
import com.xfactor.noted.getLists

class NewlistViewModel : ViewModel() {

    private val lastId = getLists().last().list.uId
    private val lastElementId = getListItems().last().uId

    private var _listItem = MutableLiveData<ListWithListItems>().apply {
        value = ListWithListItems(
            com.xfactor.noted.database.List(lastId + 1, "Example title"),
            mutableListOf()
        )
    }
    var listItem: LiveData<ListWithListItems> = _listItem
    fun setTitle(title: String) {
        _listItem.postValue(
            ListWithListItems(
                com.xfactor.noted.database.List(
                    _listItem.value!!.list.uId,
                    title
                ), _listItem.value!!.listItems
            )
        )
    }

    fun addItem(item: String) {
        val currentVal = _listItem.value ?: return
        val elements = currentVal.listItems
        _listItem.postValue(
            ListWithListItems(
                com.xfactor.noted.database.List(currentVal.list.uId, currentVal.list.title),
                elements.plus(
                    ListItem(
                        lastElementId + 1, currentVal.list.uId, item
                    )
                )
            )
        )
        Log.e("list uId", currentVal.list.uId.toString())
        Log.e("list element uId", (getListItems().size + 1).toString())
    }
}
