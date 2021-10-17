package com.tuwaiq.recyclerviewapplication

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class UserRecycleViewAdapter(private val userList: List<Orders>):
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_view_activity,
            parent, false)
        return UserAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        val user = userList[position]
        holder.orderNumTextView.text = user.orderNum.toString()
        holder.orderNameTextView.text = user.orderPic.toString()
    }

    override fun getItemCount(): Int {
        return userList.size
    }


}


class UserAdapter{
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val orderNumTextView: TextView = itemView.findViewById(R.id.order_num)
        val orderNameTextView: TextView = itemView.findViewById(R.id.order_name)
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            Toast.makeText(itemView.context, "${orderNumTextView.text} pressed!!", Toast.LENGTH_SHORT).show()
        }
    }


}