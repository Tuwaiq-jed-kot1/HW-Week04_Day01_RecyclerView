package com.tuwaiq.myhw_week4_d1_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var userList :MutableList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.card_view)
        userList= mutableListOf<User>()

        for (i in 1..100){
            val user =User("fname $i", "lname $i", i )
            userList +=user
        }

        recyclerView.layoutManager= LinearLayoutManager(this) // there is 3 different layout it has orientation
        recyclerView.adapter=UserRecycleViewAdapter(userList)

    }
}