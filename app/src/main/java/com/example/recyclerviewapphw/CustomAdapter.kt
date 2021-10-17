package com.example.recyclerviewapphw

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val userList: List<User>) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        holder.idTextView.text = "ID: ${user.id}"
        holder.nameTextView.text = user.Name
      }
    override fun getItemCount(): Int {
        return userList.size
    }
}

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var idTextView = itemView.findViewById<TextView>(R.id.tvId)
        val nameTextView: TextView = itemView.findViewById(R.id.tvName)
        init{
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            Toast.makeText(itemView.context,idTextView.text, Toast.LENGTH_SHORT).show()
        }
    }

