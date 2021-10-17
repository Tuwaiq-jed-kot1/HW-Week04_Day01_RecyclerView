package com.example.recyclerviewapphw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerV: RecyclerView
    private var data: MutableList<User> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerV = findViewById(R.id.rvRecycleView)

        for (i in 1..15) {
            val user = User(i,resources.getStringArray(R.array.Names)[i-1])
            data += user
        }
        recyclerV.layoutManager = LinearLayoutManager(this)
        recyclerV.adapter = CustomAdapter(data)


    }
}