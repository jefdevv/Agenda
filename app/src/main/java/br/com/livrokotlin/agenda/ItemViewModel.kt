package br.com.livrokotlin.agenda

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemViewModel : ViewModel() {
    private var itens = mutableListOf<ItemModel>()
    val itensLiveData = MutableLiveData<List<ItemModel>>()

    fun addItem(nome: String) {

        val item = ItemModel(nome = nome, onRemove = ::removeItem)
        itens.add(item)
        itensLiveData.value = itens


    }

    private fun removeItem(itemModel: ItemModel) {
        itens.remove(itemModel)
        itensLiveData.value = itens

    }
}