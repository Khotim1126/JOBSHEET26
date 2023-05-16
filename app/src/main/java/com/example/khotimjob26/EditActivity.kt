package com.example.khotimjob26

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class EditActivity : AppCompatActivity() {

    private lateinit var judulEdit: EditText
    private lateinit var isiEdit: EditText
    private lateinit var simpanBtn: Button

    private val JUDUL_KEY: String = "judul"
    private val ISI_KEY: String = "isi"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        judulEdit = findViewById(R.id.judulEdit)
        isiEdit = findViewById(R.id.isiEdit)
        simpanBtn = findViewById(R.id.simpanBtn)

        simpanBtn.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            intent.putExtra(JUDUL_KEY, judulEdit.text.toString())
            intent.putExtra(ISI_KEY, isiEdit.text.toString())
            startActivity(intent)
        }
    }
}