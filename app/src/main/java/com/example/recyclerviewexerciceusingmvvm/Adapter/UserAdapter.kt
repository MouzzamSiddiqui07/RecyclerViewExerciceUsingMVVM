package com.example.recyclerviewexerciceusingmvvm.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexerciceusingmvvm.Model.ModelUser
import com.example.recyclerviewexerciceusingmvvm.R

class UserAdapter(private val context : Context, private val modelUserList : ArrayList<ModelUser>) : RecyclerView.Adapter<UserAdapter.ViewHolder>()
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val modelUser =  modelUserList[position]
        holder.usernameTextView.text = modelUser.username
        holder.userMobileNumberTextView.text = modelUser.userMobileNumber
    }

    override fun getItemCount(): Int {
        return modelUserList.size
    }


    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        val imageView =  itemView.findViewById<ImageView>(R.id.userImageView)
        val usernameTextView = itemView.findViewById<TextView>(R.id.usernameTextView)
        val userMobileNumberTextView = itemView.findViewById<TextView>(R.id.userMobileNumber)
    }
}