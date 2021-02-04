package com.example.mysubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar

class AboutActivity : AppCompatActivity() {
    private var title:String = "Default"
    companion object{
        const val EXTRA_judul = "extra_judul"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val judul = intent.getStringExtra(DetailActivity.EXTRA_judul)
        if (judul != null) {
            title = judul
        }
        setActionBarTitle(title)
    }

    private fun setActionBarTitle(title: String){
        if(supportActionBar != null){
            (supportActionBar as ActionBar).title = title
        }
    }
}