package com.example.firstfirestore

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.android.synthetic.main.activity_main_screen.*

class mainScreen : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        val docRef = db.collection("Users")
        .get()
            .addOnCompleteListener(object : OnCompleteListener<QuerySnapshot> {
                override fun onComplete(p0: Task<QuerySnapshot>) {
                    if (p0.isSuccessful) {
                        for (document in p0.result!!) {
                            nameview.text = document.data["user_name"].toString()
                            numberview.text = document.data["user_number"].toString()
                            addressview.text = document.data["address"].toString()
                        }
                    } else {
                        Toast.makeText(applicationContext,"Failed to Load" , Toast.LENGTH_SHORT).show()
                    }
                }


            })
            .addOnFailureListener { exception ->
                Log.e("TAG", "get failed with ", exception)
            }
    }
}