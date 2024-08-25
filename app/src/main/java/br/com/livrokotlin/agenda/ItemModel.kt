package br.com.livrokotlin.agenda

data class ItemModel(val nome: String, val onRemove: (ItemModel) -> Unit)