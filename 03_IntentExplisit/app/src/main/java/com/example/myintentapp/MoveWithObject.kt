package com.example.myintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithObject : AppCompatActivity() {
    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val tvObject: TextView = findViewById(R.id.tv_object_received)
        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
        val text1 = """
            Name    : ${person.name}
            Age     : ${person.age}
            Email   : ${person.email}
            Location: ${person.city}
        """.trimIndent()
        tvObject.text = text1
    }
}