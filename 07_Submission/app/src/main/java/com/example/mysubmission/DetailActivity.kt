package com.example.mysubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar

class DetailActivity : AppCompatActivity(){
    private var title: String = "Mode List"
    companion object {
        const val EXTRA_namaSEKOLAH = "extra_sekolah"
        const val EXTRA_akreditasiSEKOLAH = "extra_akreditasiSekolah"
        const val EXTRA_jurusanSEKOLAH = "extra_jurusanSekolah"
        const val EXTRA_contactSEKOLAH = "extra_contactSekolah"
        const val EXTRA_alamatSEKOLAH = "extra_alamatSekolah"
        const val EXTRA_coverSEKOLAH = "extra_coverSekolah"
        const val EXTRA_kegiatanSEKOLAH1 = "extra_kegiatanSekolah1"
        const val EXTRA_kegiatanSEKOLAH2 = "extra_kegiatanSekolah2"
        const val EXTRA_deskripsiSEKOLAH = "extra_deksripsiSekolah"
        const val EXTRA_judul = "extra_judul"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvNamaSekolah: TextView = findViewById(R.id.hp_namaSekolah)
        val tvCover: ImageView = findViewById(R.id.hp_coverSekolah)
        val tvAkreditasi: TextView = findViewById(R.id.hp_akreditasi)
        val tvJurusan: TextView = findViewById(R.id.hp_jurusan)
        val tvContact: TextView = findViewById(R.id.hp_contact)
        val tvAlamat: TextView = findViewById(R.id.hp_alamat)
        val tvDeskripsi: TextView = findViewById(R.id.hp_deskripsiSekolah)
        val tvKegiatan1: ImageView = findViewById(R.id.hp_img_view_1)
        val tvKegiatan2: ImageView = findViewById(R.id.hp_img_view_2)

        val name = intent.getStringExtra(EXTRA_namaSEKOLAH)
        val akreditasi = intent.getStringExtra(EXTRA_akreditasiSEKOLAH)
        val jurusan = intent.getStringExtra(EXTRA_jurusanSEKOLAH)
        val contact = intent.getStringExtra(EXTRA_contactSEKOLAH)
        val alamat = intent.getStringExtra(EXTRA_alamatSEKOLAH)
        val deskripsi = intent.getStringExtra(EXTRA_deskripsiSEKOLAH)
        val cover = intent.getIntExtra(EXTRA_coverSEKOLAH,0)
        val kegiatan1 = intent.getIntExtra(EXTRA_kegiatanSEKOLAH1,0)
        val kegiatan2 = intent.getIntExtra(EXTRA_kegiatanSEKOLAH2,0)
        val judul = intent.getStringExtra(EXTRA_judul)
        if (judul != null) {
            title = judul
        }
        setActionBarTitle(title)


        tvNamaSekolah.text = name
        tvAkreditasi.text = akreditasi
        tvJurusan.text = jurusan
        tvContact.text = contact
        tvAlamat.text = alamat
        tvDeskripsi.text = deskripsi
        tvCover.setImageResource(cover)
        tvKegiatan1.setImageResource(kegiatan1)
        tvKegiatan2.setImageResource(kegiatan2)
    }

    private fun setActionBarTitle(title: String){
        if(supportActionBar != null){
            (supportActionBar as ActionBar).title = title
        }
    }
}
