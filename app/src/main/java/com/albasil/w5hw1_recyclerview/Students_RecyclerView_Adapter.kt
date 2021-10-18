package com.albasil.w5hw1_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


//inherited from main class           studentArrayList = arrayListOf<Students>()
class Students_RecyclerView_Adapter(private val studentList:List<Students>):
        RecyclerView.Adapter<StudentAdapter.ViewHolder>(){


    private var images = intArrayOf(R.drawable.student,R.drawable.student,R.drawable.student,R.drawable.student,R.drawable.student,R.drawable.student,R.drawable.student,R.drawable.student,R.drawable.student,R.drawable.student,R.drawable.student,R.drawable.student,R.drawable.student,R.drawable.student,R.drawable.student,)




     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_layout, parent,false)
// or            .inflate(R.layout.recycler_view, parent,false)

        return  StudentAdapter.ViewHolder(view)
    }




    //-------------holdr id & name
    override fun onBindViewHolder(holder: StudentAdapter.ViewHolder, position: Int) {

        val student=studentList[position]
        holder.id_student.text = " ID# ${student.id.toString()}"
        holder.name_studenyt.text = "${student.name} "



        holder.id_image.setImageResource(images[position])


    }


    //-----------to get Size---------------
    override fun getItemCount(): Int {
        return studentList.size
    }


}

class StudentAdapter{
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView),

        View.OnClickListener{
        var id_image:ImageView
        val id_student: TextView = itemView.findViewById(R.id.id_textView)
        val name_studenyt: TextView = itemView.findViewById(R.id.name_textView)


        init {
            itemView.setOnClickListener(this)
            id_image =itemView.findViewById(R.id._id_image)
        }

        override fun onClick(v: View?) {
            Toast.makeText(itemView.context,"${id_student.text} -> ${name_studenyt.text}", Toast.LENGTH_SHORT).show()

        }
    }

}