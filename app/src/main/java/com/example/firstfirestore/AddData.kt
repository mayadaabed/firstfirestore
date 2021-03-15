package com.example.firstfirestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_add_data.*
import kotlinx.android.synthetic.main.activity_main.*

class AddData : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_data)
        btn_save.setOnClickListener {
            saveToFirbase()
        }
    }

    fun saveToFirbase(){
        var username = username.text.toString()
        var usernumber = usernumber.text.toString()
        var address = address.text.toString()

        var map = mutableMapOf("user_name" to username , "user_number " to usernumber, "address" to address)

        db.collection("Users")
            .add(map)
            .addOnSuccessListener {
                Toast.makeText(this,"Added Successfully" , Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this,"Failed to add" , Toast.LENGTH_SHORT).show()
            }



    }
}