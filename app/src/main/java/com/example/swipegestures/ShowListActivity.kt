package com.example.swipegestures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShowListActivity : AppCompatActivity() {

    val randomList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_list)

        for(i in 'a'..'z') { randomList.add(i.toString()) }

        val adapter = ListAdapter(randomList, this)
        val rv = findViewById<RecyclerView>(R.id.rv_showList)
        rv.layoutManager = LinearLayoutManager(this)
        rv.itemAnimator  = DefaultItemAnimator()
        rv.adapter = adapter


    }
}