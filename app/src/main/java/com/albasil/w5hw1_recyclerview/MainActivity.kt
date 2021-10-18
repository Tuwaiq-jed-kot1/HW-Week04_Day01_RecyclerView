package com.albasil.w5hw1_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {

    private lateinit var _recyclerView:RecyclerView
    private var database = mutableListOf<Students>()

    private lateinit var dbReference :DatabaseReference
    private lateinit var studentArrayList:ArrayList<Students>

    private var studentName = arrayListOf<String>("Badr Fadul","ALBails","Bashayer Alosaimi","Faisal Alqahtani","Marah  Albossi","Abdulaziz Fahad","Abdullah Almohaimeed","abdullah ALshehri","Bails","ahmed","TA\n" +
            "Abeer alghamdi","Abrar Alqubishi","Hamza","Afnan Almohammdi","HaniDabash","Asma Alghamdi")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        _recyclerView = findViewById(R.id.id_recyclerView)




        //--------Create name and Id from data class 1 to 15
        for (item in 1..studentName.size-1){


            val student=Students("Name: ${studentName[item]}",item)

            //put data to database
            database +=student
        }
        //----Lay out Manager----
        _recyclerView.layoutManager = LinearLayoutManager(this)


        //Adapter
        _recyclerView.adapter =Students_RecyclerView_Adapter(database)


        _recyclerView.setHasFixedSize(true)

        studentArrayList = arrayListOf<Students>()
        getStudentData()


    }

    private fun getStudentData() {

        dbReference= FirebaseDatabase.getInstance().getReference("students")
        dbReference.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){


                    for (studentSnapshot in snapshot.children){
                        val  studen= studentSnapshot.getValue(Students::class.java)
                        studentArrayList.add(studen!!)

                    }
                    _recyclerView.adapter=Students_RecyclerView_Adapter(studentArrayList)

                }

            }

            override fun onCancelled(error: DatabaseError) {

                Toast.makeText(this@MainActivity,"$---- ->Error", Toast.LENGTH_SHORT).show()



            }

        })
    }
}