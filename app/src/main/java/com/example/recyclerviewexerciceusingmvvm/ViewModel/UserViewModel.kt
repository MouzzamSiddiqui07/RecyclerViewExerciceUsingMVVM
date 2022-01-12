package com.example.recyclerviewexerciceusingmvvm.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerviewexerciceusingmvvm.Model.ModelUser

class UserViewModel : ViewModel
{

    var username = ""
    var userMobileNumber = ""
    var imagePath = ""

    constructor() : super()
    constructor(modelUser : ModelUser) : super() {
        this.username = modelUser.username
        this.userMobileNumber = modelUser.userMobileNumber
        this.imagePath = modelUser.imagePath
    }

    var arrayListMutableLiveData  = MutableLiveData<ArrayList<ModelUser>>()

    var arrayList = ArrayList<ModelUser>()


    fun getMutableArrayList() : MutableLiveData<ArrayList<ModelUser>>
    {

        val modelUser1 = ModelUser("mouzzam","8178094410","image1.png")
        val modelUser2 = ModelUser("Rakshit","8178094410","image1.png")
        val modelUser3 = ModelUser("Shiv Lal Jat","8178094410","image1.png")
        val modelUser4 = ModelUser("Divya","8178094410","image1.png")
        val modelUser5 = ModelUser("Shubham","8178094410","image1.png")
        val modelUser6 = ModelUser("Mehak","8178094410","image1.png")
        val modelUser7 = ModelUser("Rupal","8178094410","image1.png")
        val modelUser8 = ModelUser("Swati","8178094410","image1.png")
        val modelUser9 = ModelUser("Neeraj","8178094410","image1.png")
        val modelUser10 = ModelUser("Imran","8178094410","image1.png")
        val modelUser11 = ModelUser("Rohit","8178094410","image1.png")
        val modelUser12 = ModelUser("Shivam","8178094410","image1.png")


        arrayList.add(modelUser1)
        arrayList.add(modelUser2)
        arrayList.add(modelUser3)

        arrayList.add(modelUser4)
        arrayList.add(modelUser5)
        arrayList.add(modelUser6)
        arrayList.add(modelUser7)
        arrayList.add(modelUser8)
        arrayList.add(modelUser9)
        arrayList.add(modelUser10)
        arrayList.add(modelUser11)
        arrayList.add(modelUser12)


        arrayListMutableLiveData.value = arrayList


        return arrayListMutableLiveData

    }


}
