package com.example.recyclerviewexerciceusingmvvm.Adapter

import MyCustomDialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexerciceusingmvvm.Model.ModelUser
import com.example.recyclerviewexerciceusingmvvm.Model.ModelUserDataItem
import com.example.recyclerviewexerciceusingmvvm.R
import com.example.recyclerviewexerciceusingmvvm.R.id.addButton

class UserAdapter(private val context : Context, private val modelUserList : List<ModelUserDataItem>?, private val fragmentManager : FragmentManager) : RecyclerView.Adapter<UserAdapter.ViewHolder>() , MyCustomDialog.Listener
{


    private  var  resultString : String = ""
    val updatedTextView  : TextView? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val modelUser = modelUserList?.get(position)
        holder.userIdTextView.text = modelUser?.userId.toString()
        holder.titleTextView.text = modelUser?.title
        holder.bodyTextView.text = modelUser?.body
        if(position == 1)
        {
            holder.addButton.visibility = View.VISIBLE
        }

        holder.addButton.setOnClickListener {
            showDialog()


        }

    }

    private fun showDialog() {
         val dialog= MyCustomDialog()
        dialog.setListener(this@UserAdapter)
        dialog.show(fragmentManager, "Hiii")



    }

    override fun getItemCount(): Int {
        if (modelUserList != null) {
            return modelUserList.size
        }
        else {
            return 0
        }
    }


    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {

        val  userIdTextView = itemView.findViewById<TextView>(R.id.userIdTextView)
        val  titleTextView = itemView.findViewById<TextView>(R.id.titleTextView)
        val  bodyTextView= itemView.findViewById<TextView>(R.id.bodyTextView)
        val  addButton = itemView.findViewById<Button>(R.id.addButton)
        val updatedTextView = itemView.findViewById<TextView>(R.id.updatedTextView)
    }

    override fun returnData(result: String) {
          resultString = result
          Log.d("kkk", "result string : $resultString")
    }


}