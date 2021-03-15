package com.example.firstfirestore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_add.setOnClickListener {
            var intent = Intent(this, AddData::class.java)
            startActivity(intent)
        }

        btn_show.setOnClickListener {
            var intent = Intent(this, mainScreen::class.java)
            startActivity(intent)
        }
    }


}