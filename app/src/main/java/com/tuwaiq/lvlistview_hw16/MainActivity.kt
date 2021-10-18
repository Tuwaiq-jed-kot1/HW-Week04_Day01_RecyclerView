package com.tuwaiq.lvlistview_hw16

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.BufferedReader
import java.io.FileReader
import java.nio.file.Paths


class MainActivity : AppCompatActivity() {
    private lateinit var flowersList:MutableList<Flowers>
    private lateinit var RV:RecyclerView
    private lateinit var flowerName :List<String>
    private lateinit var imageid :List<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        flowerName =resources.getStringArray(R.array.flowers_name).toList()

        imageid = listOf<Int>(R.drawable.a1,
            R.drawable.a2,
            R.drawable.a3,
            R.drawable.a4,
            R.drawable.a5,
            R.drawable.a6,
            R.drawable.a7,
            R.drawable.a8,
            R.drawable.a9,
            R.drawable.a10,
            R.drawable.a11,
            R.drawable.a12,
            R.drawable.a13,
            R.drawable.a14,
            R.drawable.a15,
            R.drawable.a16

        )
        flowersList= mutableListOf<Flowers>()
        for(i in 0..15){
            val item= Flowers(i,flowerName[i+1],imageid[i])
                    flowersList +=item
        }

   RV=findViewById(R.id.RV)
        RV.layoutManager=LinearLayoutManager(this)
        RV.adapter=FlowersAdapter(flowersList)
    }
}


