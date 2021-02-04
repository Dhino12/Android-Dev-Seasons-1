package com.example.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvResult:TextView

    //Menerima data
    companion object{
        private const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Tampilan pertama pada UI Interface pada activity_main yang sudah disetting
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        //Ketika tombol btnMoveActitity di click maka akan memanggil fungsi onClick
        btnMoveActivity.setOnClickListener(this)

        val btnMoveActivityData :Button = findViewById(R.id.btn_move_activity_data)
        btnMoveActivityData.setOnClickListener(this)

        val btnDialPhone :Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        val btnMoveWithObject: Button = findViewById(R.id.btn_move_with_object)
        btnMoveWithObject.setOnClickListener(this)

        val btnMoveForResult:Button = findViewById(R.id.btn_move_for_result)
        btnMoveForResult.setOnClickListener(this)
        tvResult = findViewById(R.id.tv_result)
    }

    override fun onClick(v: View){
        when(v.id){
            //Membuat Activity Baru tanpa data (Intent_Sederhana)
            R.id.btn_move_activity -> {
                //Pindah Activity dengan this@MainActivity = aktivity sekarang
                    //ke MoveActivity::class.java = aktivity selanjutnya
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent) // menjalankan intent
            }
            //Membuat Acitivity Baru dengan data (Explicit_Intent)
            R.id.btn_move_activity_data -> {
                //Menempatkan data ke object intent
                val moveWithObjectIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                //mengirim data dengan .putExtra yang menampung key = EXTRA_NAME,
                    // dan value = "latina" ,dst .dan mendukung hampir semua tipedata
                moveWithObjectIntent.putExtra(MoveWithDataActivity.EXTRA_NAME,"Latina")
                moveWithObjectIntent.putExtra(MoveWithDataActivity.EXTRA_AGE,10)
                startActivity(moveWithObjectIntent)
            }
            //Menggunakan Parceleble untuk mengirim object/data dalam jumlah banyak (Explicit_Intent)
            R.id.btn_move_with_object -> {
                val person = Person(
                    "Latina",
                    10,
                    "latinaKawaii@gmail.com",
                    "TheLegendOfCity"
                )
                val moveWithObjectIntent = Intent(this@MainActivity, MoveWithObject::class.java)
                moveWithObjectIntent.putExtra(MoveWithObject.EXTRA_PERSON,person)
                startActivity(moveWithObjectIntent)
            }
            //Membuat Activity Baru dengan (Implicit_Intent)
            R.id.btn_dial_number -> {
                val phoneNumber = "082191029737"
                //Action_Dial = menentukan intent filter dari aplikasi yang dapat
                    //menangani action tsb ada banyak action yang dapat digunakan
                //Action = Intent.ACTION_DIAL

                //uri (Unifrom Resource Identifire)= Uri.parse("$tel:$phoneNumber")
                    //uri = untaian karakter untuk mengidentifikasi nama, sumber, internet
                        //sesuai dengan RFC 2396
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL,Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            //Pindah Activity 
            R.id.btn_move_for_result -> {
                val moveForResult = Intent(this@MainActivity, MoveResultActivity2::class.java)
                //Mengirim data
                startActivityForResult(moveForResult, REQUEST_CODE)
            }
        }
    }

    //ketika MoveResult ditutp dan mengembalikan nilai ,method ini akan dijalankan
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE){
            if(resultCode == MoveResultActivity2.RESULT_CODE){
                //akan menerima nilai tersebut dan menampilkannya
                val selectedValue = data?.getIntExtra(MoveResultActivity2.EXTRA_SELECTED_VALUE,0)
                tvResult.text = "Hasil: $selectedValue"
            }
        }
    }

}