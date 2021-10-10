package com.yaroyazeed.foodapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity(){
    lateinit var recyclerView : RecyclerView
    lateinit var mainAdapter : MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = GridLayoutManager(this,2)


        val options = FirebaseRecyclerOptions.Builder<MainModel>()
            .setQuery(FirebaseDatabase.getInstance().reference.child("FoodItems")
                ,MainModel::class.java)
            .setLifecycleOwner(this)
            .build()

        mainAdapter = MainAdapter(options, this)
        recyclerView.adapter = mainAdapter

    }

    override fun onStart() {
        super.onStart()
        mainAdapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        mainAdapter.stopListening()
    }


}