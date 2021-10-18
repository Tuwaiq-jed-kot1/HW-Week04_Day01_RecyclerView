package com.tuwaiq.myhw_week4_d1_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class UserRecycleViewAdapter(private val userList:List<User>):RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        //parent is the recycle layout which will get injected with views (items)
        val view =LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return CustomAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        val user =userList[position]
        holder.idTView.text=(user.id).toString()
        holder.nameTView.text= "${user.fname} ${user.lname}"
      //  holder.imagView.text = user.imag.toString()

    }

    override fun getItemCount(): Int {
        return userList.size
    }
}


class CustomAdapter {
    class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView),
        View.OnClickListener{
        // item view here is from the on create function where we created9 the view
        val idTView:TextView =itemView.findViewById(R.id.item_title)
        val nameTView:TextView =itemView.findViewById(R.id.item_delail)
        val imagView:TextView =itemView.findViewById(R.id.imageView)
        init{
            itemView.setOnClickListener(this)

        }
        override fun onClick(p0: View?) {
            Toast.makeText(itemView.context, "${idTView.text} cliced", Toast.LENGTH_SHORT).show()
        }
    }
}