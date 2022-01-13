package com.example.recyclerviewexerciceusingmvvm

import android.graphics.ColorSpace
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.networkwithretrofit.ApiInterface
import com.example.recyclerviewexerciceusingmvvm.Adapter.UserAdapter
import com.example.recyclerviewexerciceusingmvvm.Model.ModelUserData
import com.example.recyclerviewexerciceusingmvvm.Model.ModelUserDataItem
import com.example.recyclerviewexerciceusingmvvm.Service.RetrofitInstance
import com.example.recyclerviewexerciceusingmvvm.ViewModel.UserViewModel
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {


    private var recyclerView : RecyclerView? = null
    private var userAdapter : UserAdapter?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.recyclerView)


        val retService: ApiInterface =
            RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)

        val callObject = retService.getPosts()


        callObject.enqueue(object : retrofit2.Callback<List<ModelUserDataItem>>
        {

            override fun onResponse(
                call: Call<List<ModelUserDataItem>>,
                response: Response<List<ModelUserDataItem>>
            ) {
                if(response?.body() != null)
                {
                   var postList = response.body()
                    userAdapter = UserAdapter(this@MainActivity , postList, supportFragmentManager)
            recyclerView!!.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView!!.adapter = userAdapter

                }

            }

            override fun onFailure(call: Call<List<ModelUserDataItem>>, t: Throwable) {
                Log.d("kkk","failure response : "+t.message)
            }

        })


//        val viewModel = ViewModelProvider(this)[UserViewModel::class.java]
//
//        viewModel.getMutableArrayList().observe(this , Observer { userModels->
//
//            userAdapter = UserAdapter(this@MainActivity , userModels)
//            recyclerView!!.layoutManager = LinearLayoutManager(this@MainActivity)
//            recyclerView!!.adapter = userAdapter
//
//        })
    }
}