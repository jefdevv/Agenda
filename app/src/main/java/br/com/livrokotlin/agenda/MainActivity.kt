package br.com.livrokotlin.agenda

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val edtItem = findViewById<EditText>(R.id.edt_item_id)
        val btnSalvar = findViewById<Button>(R.id.btn_salvar_id)
        val recycler = findViewById<RecyclerView>(R.id.recycler_id)
        val adapter = ItemAdapter()
        recycler.adapter = adapter

        val viewModel: ItemViewModel by viewModels()

        btnSalvar.setOnClickListener() {
            if (edtItem.text.isEmpty()) {
                edtItem.error = "Campo Vazio"

            }
            viewModel.addItem(edtItem.text.toString())
            edtItem.text.clear()
        }

        viewModel.itensLiveData.observe(this) { itens ->
            adapter.update(itens)
        }

    }
}