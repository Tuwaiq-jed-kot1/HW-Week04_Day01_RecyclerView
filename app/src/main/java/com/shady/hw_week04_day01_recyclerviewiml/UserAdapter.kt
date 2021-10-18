package com.tuwiaq.recycleviewapp

import android.telecom.Call
import android.util.Property
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.shady.hw_week04_day01_recyclerviewiml.R
import com.shady.hw_week04_day01_recyclerviewiml.User
private const val base_url ="https://cdn.icon-icons.com/icons2/1674/PNG/512/person_110935.png"
class UserViewAdapter (private val userList:List<User>):

    RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        val view= LayoutInflater.from(parent.context).
        inflate(R.layout.recycle_view,parent,false)

        return UserAdapter.ViewHolder(view)
    }


    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        val user = userList[position]
        holder.idTextView.text = user.id.toString()
        holder.nameTextView.text = "${user.fname} ${user.lname}"
        holder.scoreTextView.text = user.score.toString()
    }

    override fun getItemCount(): Int {
        return userList.size
    }

}

class UserAdapter{
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView),View.OnClickListener{
        val idTextView:TextView = itemView.findViewById(R.id.tvId)
        val nameTextView:TextView = itemView.findViewById(R.id.tvName)
        val scoreTextView:TextView = itemView.findViewById(R.id.tvScore)

        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            Toast.makeText(itemView.context,"${idTextView.text} clicked",Toast.LENGTH_SHORT).show()
        }


    }
}