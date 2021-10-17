package com.example.rvv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val data: List<String>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder?>() {
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rowItem: View =
            LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_view, parent, false)
        return ViewHolder(rowItem)
    }

    fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = data[position]
    }

    val itemCount: Int
        get() = data.size()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {
        private val textView: TextView
        override fun onClick(view: View) {
            Toast.makeText(
                view.context,
                "position : " + getLayoutPosition().toString() + " text : " + textView.text,
                Toast.LENGTH_SHORT
            ).show()
        }

        init {
            view.setOnClickListener(this)
            textView = view.findViewById(R.id.textview)
        }
    }
}