package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var database: myDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add.setOnClickListener{
            val intent = Intent(this,Create_Card::class.java)
            startActivity(intent)
        }
        deleteAll.setOnClickListener{
            DataObject.deleteAll()
            GlobalScope.launch {
                database.dao().deleteAll()
            }
            set_Recycler()
        }
        set_Recycler()

    }
    fun set_Recycler(){
        recycler_view.adapter = Adapter(DataObject.getAllData())
        recycler_view.layoutManager= LinearLayoutManager(this)
    }
}