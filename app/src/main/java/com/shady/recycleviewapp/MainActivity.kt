package com.shady.recycleviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var data = mutableListOf<Medicine>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvRecycleView)


        val mName = arrayListOf<String>("Pandol","Abacavir","Banzel","Bentyl","Brovana","Bontril","Keflex","Keppra XR","Kuvan","Raloxifene","Raxar","Wigraine","Yohimbine","Zarontin","Zestril")
        for (i in 0..14){
            val medicine = Medicine(
                mName[i],

                i +1
            )
            data += medicine
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = UserRecycleViewAdapter(data)



    }
}