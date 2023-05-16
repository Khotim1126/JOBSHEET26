package com.example.khotimjob26

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ListActivity : AppCompatActivity() {

    private lateinit var judulView: TextView
    private lateinit var isiView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        judulView = findViewById(R.id.judulView)
        isiView = findViewById(R.id.isiView)

        val extras = intent.extras

        judulView.text = extras?.getString("judul")
        isiView.text = extras?.getString("isi")
    }
}