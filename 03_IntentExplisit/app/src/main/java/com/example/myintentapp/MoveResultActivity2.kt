package com.example.myintentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup

class MoveResultActivity2 : AppCompatActivity(), View.OnClickListener {
        private lateinit var btnChoose:Button
        private lateinit var rgNumber:RadioGroup

    companion object{
        const val EXTRA_SELECTED_VALUE="extra_selected_value"
        const val RESULT_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_result2)

        btnChoose = findViewById(R.id.btn_choose)
        rgNumber = findViewById(R.id.rg_number)

        btnChoose.setOnClickListener(this)
    }

        override fun onClick(v: View) {
            if(v.id == R.id.btn_choose){
                if(rgNumber.checkedRadioButtonId != 0){
                    val value = when(rgNumber.checkedRadioButtonId){
                        R.id.pilihan1 ->  50
                        R.id.pilihan2 ->  100
                        R.id.pilihan3 ->  150
                        R.id.pilihan4 ->  200
                        else -> 0
                    }
                    val data = Intent()
                    data.putExtra(EXTRA_SELECTED_VALUE,value)
                    setResult(RESULT_CODE,data)
                    finish()
                }
            }
        }
    }