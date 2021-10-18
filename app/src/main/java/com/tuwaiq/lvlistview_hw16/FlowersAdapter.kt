package com.tuwaiq.lvlistview_hw16


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView


class FlowersAdapter(private val flowerList:List<Flowers>):RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //parent is the recycle layout which will get injected with views (items)
        val view =LayoutInflater.from(parent.context).inflate(R.layout.items,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val flower =flowerList[position]
        holder.idTextView.text="id: "+(flower.id).toString()
        holder.nameTextView.text= flower.name
        holder.itemImage.setImageResource(flower.image)

    }

    override fun getItemCount(): Int {
        return flowerList.size
    }
}



    class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView) ,View.OnClickListener{

        // item view here is from the on create function where we created9 the view
        val idTextView:TextView =itemView.findViewById(R.id.TVid)
        val nameTextView:TextView =itemView.findViewById(R.id.TVname)
        val itemImage: ShapeableImageView = itemView.findViewById(R.id.itemPic)
        init {
            itemView.setOnClickListener(this) //
        }
        override fun onClick(p0: View?) {
            Toast.makeText(itemView.context,"${idTextView.text} clicked",Toast.LENGTH_SHORT).show()
            // this class is pure kotlin and only class know the layout is android class :app so we used itemView.context item view to reach the context
        }
    }
