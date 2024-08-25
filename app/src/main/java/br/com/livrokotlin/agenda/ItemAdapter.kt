package br.com.livrokotlin.agenda

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter : RecyclerView.Adapter<ItemViewHolder>() {
    private var itemList = listOf<ItemModel>()

    fun update(newItens: List<ItemModel>){
        itemList = newItens
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

}

class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val txtItem = view.findViewById<TextView>(R.id.txt_item_id)
    val imgRemove = view.findViewById<ImageView>(R.id.img_delete_id)

    fun bind(item: ItemModel) {
        txtItem.text = item.nome
        imgRemove.setOnClickListener() {
            item.onRemove(item)
        }

    }

}
