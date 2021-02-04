package com.example.myintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithDataActivity : AppCompatActivity() {
    companion object{
        //Const = nilai tetap yang tidak dapat diubah valuenya/nilainya
        //Constanta menetapkan key = EXTRA_AGE / EXTRA_NAME dengan
            // value extra_age / extra_name
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)
        val tvDataReceiver: TextView = findViewById(R.id.tv_data_received)

        //Menerima data yang dikirimkan dari MoveWithDataActivity
            //Mengambilny berdasarkan Key yang harus sama
        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE,0)

        val text = "Name: $name, Your Age: $age"
        tvDataReceiver.text = text
    }
}