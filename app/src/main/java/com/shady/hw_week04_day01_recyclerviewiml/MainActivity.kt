package com.shady.hw_week04_day01_recyclerviewiml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tuwiaq.recycleviewapp.UserViewAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var data = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     recyclerView.setOnClickListener{R.id.rvRecycleView}
        for (i in 1..20){
            val user = User("fname $i","lname $i" ,i,i*2,)
            data += user
        }

        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter= UserViewAdapter(data)
    }
}