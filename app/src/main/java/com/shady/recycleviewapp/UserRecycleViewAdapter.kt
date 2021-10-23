package com.shady.recycleviewapp

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class UserRecycleViewAdapter(private val medicineList: List<Medicine>) :
    RecyclerView.Adapter<medicineAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            medicineAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_view_item, parent,false)
        return medicineAdapter.ViewHolder(view)
    }
    override fun onBindViewHolder(holder: medicineAdapter.ViewHolder,
                                  position: Int) {
        val medicine = medicineList[position]
        holder.idTextView.text = medicine.id.toString()
        holder.nameTextView.text = "${medicine.mName}"
    }
    override fun getItemCount(): Int {
        return medicineList.size
    }
}

class medicineAdapter {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        val idTextView: TextView = itemView.findViewById(R.id.tvId)
        val nameTextView: TextView = itemView.findViewById(R.id.tvName)
         init {
    itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
        Toast.makeText(itemView.context, "${idTextView.text} clicked", Toast.LENGTH_SHORT).show()

    }
}
}

