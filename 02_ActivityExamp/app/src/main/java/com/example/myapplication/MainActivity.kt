package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    //Menyesuaikan semua komponen yang dideklarasi
    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    //inisialisasi pertama kali aplikasi berjalan
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //akan menampilkan UI dari layout activity_main
        setContentView(R.layout.activity_main)
        //Casting View
        //menyesuaikan komponen edtHeight dgn komponen dengan id edt_height
        //dilayout activity_main dengan findViewById()
        edtHeight = findViewById(R.id.edt_height)
        edtWidth = findViewById(R.id.edt_width)
        edtLength = findViewById(R.id.edt_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)
        //Ketika button diclick lakukan, maka akan merunjuk ke object Activity
        //yakni Onclick dan melakukan proses yang ada didalamnya
        btnCalculate.setOnClickListener(this)

        //Menggunakan nilai bundle yang telah disimpan sebelumnya pada
        //onSavedInstanceState, nilai tsb digunakan dengan key yang sama dgn saat menyimapan
        if(savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT) as String
            tvResult.text = result
        }
    }
    //Fungsi ketika aplikasi atau suatu tombol di click
    override fun onClick(v: View) {
        if(v.id == R.id.btn_calculate){
            //Menangkap inputan dari user berupa string
            //trim() = menghiraukan spasi jika ada karena dia number
            val inputLength = edtLength.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()

            //Validasi kolom harus diisi
            var isEmptyFields = false
            var isInvalidDouble = false
            if(inputLength.isEmpty()){
                isEmptyFields = true
                edtLength.error = "Field ini harus diisi"
            }
            if(inputHeight.isEmpty()){
                isEmptyFields = true
                edtHeight.error = "Field ini harus diisi"
            }
            if(inputWidth.isEmpty()){
                isEmptyFields = true
                edtWidth.error = "Field ini harsu diisi"
            }
            //Validasi inputan berupa bukan angka
            val length = toDouble(inputLength)
            val width = toDouble(inputWidth)
            val height = toDouble(inputHeight)

            if(length == null){
                isInvalidDouble = true
                edtLength.error = "Field ini harus berupa nomor yang valid"
            }
            if(width == null){
                isInvalidDouble = true
                edtWidth.error = "Field ini harus berupa nomor yang valid"
            }
            if(height == null){
                isInvalidDouble = true
                edtHeight.error = "Field ini harus berupa nomor yang valid"
            }
            //Lakukan perhitungan Jika tidak ada kondisi yang salah
            if(!isEmptyFields && !isInvalidDouble){
                val volume = height as Double * length as Double * width as Double
                tvResult.text = volume.toString()
            }
        }
    }
    //Validasi inputan berupa bukan angka
    private fun toDouble(str:String):Double?{
        return try{
            str.toDouble()
        }catch (e: NumberFormatException){
            null
        }
    }

    companion object{
        private const val STATE_RESULT= "state_result"
    }
    //Menyimpan hasil perhitungan ke dalam onSaveInstanceState sebelum didestroy
    //karena berubah rotasi layar, atau yang lainnya
    //dengan konsep key = STATE_RESULT dan value = tvResult
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT,tvResult.text.toString())
    }

}