package com.example.recyclerviewexerciceusingmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexerciceusingmvvm.Adapter.UserAdapter
import com.example.recyclerviewexerciceusingmvvm.ViewModel.UserViewModel

class MainActivity : AppCompatActivity() {


    private var recyclerView : RecyclerView? = null
    private var userAdapter : UserAdapter?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        val viewModel = ViewModelProvider(this)[UserViewModel::class.java]

        viewModel.getMutableArrayList().observe(this , Observer { userModels->

            userAdapter = UserAdapter(this@MainActivity , userModels)
            recyclerView!!.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView!!.adapter = userAdapter

        })
    }
}