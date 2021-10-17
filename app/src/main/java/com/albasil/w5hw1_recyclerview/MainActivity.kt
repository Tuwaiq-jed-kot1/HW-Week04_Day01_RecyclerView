package com.albasil.w5hw1_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var _recyclerView:RecyclerView
    private var database = mutableListOf<Students>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _recyclerView = findViewById(R.id.id_recyclerView)


        //--------Create name and Id from data class 1 to 15
        for (item in 1..15){


            val student= Students("Student: $item", item)

            //put data to database
            database +=student
        }
        //----Lay out Manager----
        _recyclerView.layoutManager = LinearLayoutManager(this)


        //Adapter
        _recyclerView.adapter =Students_RecyclerView_Adapter(database)


    }
}