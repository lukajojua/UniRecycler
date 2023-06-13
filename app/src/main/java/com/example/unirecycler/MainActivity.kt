package com.example.unirecycler

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private var emails= mutableListOf<String>()
    private var names= mutableListOf<String>()
    private var images= mutableListOf<Int>()
    private lateinit var recyclerView: RecyclerView;




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.rv_recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=RecyclerAdapter(emails,names,images)
        val database = Firebase.database
        val myRef = database.getReference("message")

        myRef.setValue("i am added to this project!")




        tolist()
    }

    private fun addToList(email: String,name: String , image:Int){
        images.add(image)
        names.add(name);
        emails.add(email)
    }

    private fun tolist(){
        for (i in 1..7) {
            addToList("email $i" ,"name $i",R.mipmap.ic_launcher_round)
        }
    }
}