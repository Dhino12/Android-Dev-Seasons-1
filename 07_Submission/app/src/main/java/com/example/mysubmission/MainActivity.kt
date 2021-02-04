package com.example.mysubmission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aplikasi.myapplication13.Sekolah

class MainActivity : AppCompatActivity() {
    private var list: ArrayList<Sekolah> = arrayListOf()
    private lateinit var rvsekolah: RecyclerView
    private var title: String = "Mode List"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvsekolah = findViewById(R.id.rv_sekolah)
        rvsekolah.setHasFixedSize(true)
        list.addAll(SekolahData.listData)
        title = "Daftar Sekolah SMK dan SMKN"
        setActionBarTitle(title)
        showRecyclerList()
    }

    private fun setActionBarTitle(title: String){
        if(supportActionBar != null){
            (supportActionBar as ActionBar).title = title
        }
    }

    private fun showRecyclerList(){
        rvsekolah.layoutManager = LinearLayoutManager(this)
        val listSekolahAdapter = ListSekolahAdapter(list)
        rvsekolah.adapter = listSekolahAdapter

        listSekolahAdapter.setOnItemClickCallback(object : ListSekolahAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Sekolah) {
                showSelectedSekolah(data)
            }
        })
    }

    private fun showSelectedSekolah(sekolah: Sekolah){
//        Toast.makeText(this,"Kamu Memilih " + sekolah.nama ,
//        Toast.LENGTH_SHORT).show()

        when(sekolah.nama){
            "SMK TEKNOLOGI PELITA KARYA" -> {
                val pindahDataIntent = Intent(this@MainActivity, DetailActivity::class.java)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_namaSEKOLAH,"SMK Teknologi Pelita Karya")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_coverSEKOLAH, R.drawable.smk_teknologi_pelitakarya_cover)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_judul,"SMK TEKNOLOGI PELITA KARYA")
                pindahDataIntent.putExtra(
                    DetailActivity.EXTRA_deskripsiSEKOLAH,"""
                    SMK TEKNOLOGI PELITA KARYA suatu sekolah yang terletak di Jl. Borbok 56, Desa Cicau, Kecamatan Cikarang Pusat, Kabupaten Bekasi, Provinsi Jawa Barat 17530,
                    sekolah yang berstatus swasta ini memiliki 6 jurusan didalamnya yakni : 
                    Akutansi(B),
                    Akutansi dan Keuangan 
                    Teknik Kendaraan Ringan(B)
                    Teknik Komputer dan informatika
                    Teknik Komputer dan jaringan
                    Teknik Otomotif
                """.trimIndent())
                pindahDataIntent.putExtra(DetailActivity.EXTRA_alamatSEKOLAH,"Jl. Borbok 56, Desa Cicau, Kecamatan Cikarang Pusat, Kabupaten Bekasi, Provinsi Jawa Barat 17530,")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_contactSEKOLAH,"Unknown")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_akreditasiSEKOLAH,"B")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_jurusanSEKOLAH,"Teknik Kendaraan Ringan")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_kegiatanSEKOLAH1, R.drawable.smk_teknologi_pelitakarya_1)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_kegiatanSEKOLAH2, R.drawable.smk_teknologi_pelitakarya_2)
                startActivity(pindahDataIntent)
            }
            "SMK AMANAH BANGSA" -> {
                val pindahDataIntent = Intent(this@MainActivity, DetailActivity::class.java)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_judul,"SMK Amanah Bangsa")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_namaSEKOLAH,"SMK Amanah Bangsa")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_coverSEKOLAH, R.drawable.smk_informatika_amanah_bangsa_cover)
                pindahDataIntent.putExtra(
                    DetailActivity.EXTRA_deskripsiSEKOLAH,"""
                    SMK INFORMATIKA AMANAH BANGSA suatu sekolah yang terletak di Jl. Citarik Raya No.123 Desa Jatireja, Kecamatan Cikarang Timur, Kabupaten Bekasi, Provinsi Jawa Barat 17530,
                    sekolah yang berstatus swasta ini memiliki 6 jurusan didalamnya yakni :
                    Akuntansi
                    Akuntansi dan Keuangan
                    Multi Media (A)
                    Teknik Komputer dan Informatika
                    Teknik Komputer dan Jaringan (A)
                """.trimIndent())
                pindahDataIntent.putExtra(DetailActivity.EXTRA_alamatSEKOLAH,"Jl. Citarik Raya No.123 Desa Jatireja, Kecamatan Cikarang Timur, Kabupaten Bekasi, Provinsi Jawa Barat 17530")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_contactSEKOLAH,"(021) 89143605")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_akreditasiSEKOLAH,"A")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_kegiatanSEKOLAH1, R.drawable.smk_informatika_amanah_bangsa_1)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_kegiatanSEKOLAH2, R.drawable.smk_informatika_amanah_bangsa_2)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_jurusanSEKOLAH,"Administrasi Perkantoran")
                startActivity(pindahDataIntent)
            }
            "SMK IT BINA MADANI" -> {
                val pindahDataIntent = Intent(this@MainActivity, DetailActivity::class.java)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_judul,"SMK IT BINA MADANI")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_namaSEKOLAH, "SMK IT Bina Madani")
                pindahDataIntent.putExtra(
                    DetailActivity.EXTRA_coverSEKOLAH,
                        R.drawable.smk_it_bina_madani_cover
                )
                pindahDataIntent.putExtra(
                    DetailActivity.EXTRA_deskripsiSEKOLAH, """
                   SMK IT BINA MADANI suatu sekolah yang terletak di Kp. Warung Bambu RT. 01 RW. 09 Desa Telagamurni, Kecamatan Cikarang Barat
                    sekolah yang berstatus swasta ini memiliki 2 jurusan didalamnya yakni :
                    Administrasi Perkantoran
                    Manajemen Perkantoran
                """.trimIndent()
                )
                pindahDataIntent.putExtra(
                    DetailActivity.EXTRA_alamatSEKOLAH,
                    "Jl. Citarik Raya No.123 Desa Jatireja, Kecamatan Cikarang Timur, Kabupaten Bekasi, Provinsi Jawa Barat 17530"
                )
                pindahDataIntent.putExtra(DetailActivity.EXTRA_contactSEKOLAH, "0812-1996-2618")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_akreditasiSEKOLAH, "unknown")
                pindahDataIntent.putExtra(
                    DetailActivity.EXTRA_kegiatanSEKOLAH1,
                        R.drawable.smk_it_bina_madani_1
                )
                pindahDataIntent.putExtra(
                    DetailActivity.EXTRA_kegiatanSEKOLAH2,
                        R.drawable.smk_it_bina_madani_2
                )
                pindahDataIntent.putExtra(
                    DetailActivity.EXTRA_jurusanSEKOLAH,
                    "Administrasi Perkantoran"
                )
                startActivity(pindahDataIntent)
            }

            "SMK ISLAM AL-MUHAJIRIN" -> {
                val pindahDataIntent = Intent(this@MainActivity, DetailActivity::class.java)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_judul,"SMK ISLAM AL-MUHAJIRIN")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_namaSEKOLAH,"SMK Islam Al-Muhajirin ")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_coverSEKOLAH, R.drawable.smk_al_muhajirin_cover)
                pindahDataIntent.putExtra(
                    DetailActivity.EXTRA_deskripsiSEKOLAH,"""
                    SMK ISLAM AL-MUHAJIRIN BOARDING SCHOOL suatu sekolah yang terletak di Kp. Tegal Danas RT. 01 RW. 01 Desa Jayamukti, Kecamatan Cikarang Pusat,
                    sekolah yang berstatus swasta ini memiliki 6 jurusan didalamnya yakni : 
                    Administrasi Perkantoran (A)
                    Manajemen Perkantoran 
                    Teknik Kendaraan Ringan (A)
                    Teknik Otomotif(A)
                """.trimIndent())
                pindahDataIntent.putExtra(DetailActivity.EXTRA_alamatSEKOLAH,"Kp. Tegal Danas RT. 01 RW. 01 Desa Jayamukti, Kecamatan Cikarang Pusat, Kabupaten Bekasi, Provinsi Jawa Barat 17531")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_contactSEKOLAH,"Unknown")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_kegiatanSEKOLAH1, R.drawable.smk_islam_muhajirn_1)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_kegiatanSEKOLAH2, R.drawable.smk_islam_muhajirn_2)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_akreditasiSEKOLAH,"A")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_jurusanSEKOLAH,"Administrasi Perkantoran")
                startActivity(pindahDataIntent)
            }

            "SMK 11 Maret Cikarang" -> {
                val pindahDataIntent = Intent(this@MainActivity, DetailActivity::class.java)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_judul,"SMK 11 Maret Cikarang")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_namaSEKOLAH,"SMK 11 Maret Cikarang")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_coverSEKOLAH, R.drawable.smk_11_maret_cover)
                pindahDataIntent.putExtra(
                    DetailActivity.EXTRA_deskripsiSEKOLAH,"""
                    SMK 11 Maret Cikarang suatu sekolah yang terletak di Jl. Raya Imam Bonjol, Perumahan Telaga Sakinah, Desa Telagamurni, Kecamatan Cikarang Barat
                    sekolah yang berstatus swasta ini memiliki 6 jurusan didalamnya yakni : 
                    Akuntansi Perkantoran
                    Akuntansi
                    Akuntansi dan Keuangan (A)
                    Manajemen Perkantoran (A)
                    Teknik dan Bisnis Sepeda Motor
                    Teknik Kenderaan Ringan
                    Teknik Kenderaan Ringan Otomotif
                    Teknik Komputer dan Informatika
                    Teknik Komputer dan Jaringan
                    Teknik Otomotif
                    Teknik Sepeda Motor.
                """.trimIndent())
                pindahDataIntent.putExtra(DetailActivity.EXTRA_alamatSEKOLAH,"Jl. Raya Imam Bonjol, Perumahan Telaga Sakinah, Desa Telagamurni, Kecamatan Cikarang Barat, Kabupaten Bekasi, Provinsi Jawa Barat 17530.")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_contactSEKOLAH,"Unknown")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_kegiatanSEKOLAH1, R.drawable.smk_11_maret_1)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_kegiatanSEKOLAH2, R.drawable.smk_11_maret_2)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_akreditasiSEKOLAH,"A")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_jurusanSEKOLAH,"Akuntansi dan Keuangan")
                startActivity(pindahDataIntent)
            }

            "SMK KESEHATAN EL-HURRIYAH" -> {
                val pindahDataIntent = Intent(this@MainActivity, DetailActivity::class.java)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_judul,"SMK Kesehatan El-Hurriyah")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_namaSEKOLAH,"SMK Kesehatan El-Hurriyah")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_coverSEKOLAH, R.drawable.smk_kesehatan_el_hurriyah_cover)
                pindahDataIntent.putExtra(
                    DetailActivity.EXTRA_deskripsiSEKOLAH,"""
                    SMK Kesehatan El-Hurriyah suatu sekolah yang terletak di Jl. Raya Imam Bonjol, Perumahan Telaga Sakinah, Desa Telagamurni, Kecamatan Cikarang Barat
                    sekolah yang berstatus swasta ini memiliki 6 jurusan didalamnya yakni : 
                    Analisis Kesehatan (A)
                    Farmasi (A)
                    Keperawatan (A)
                """.trimIndent())
                pindahDataIntent.putExtra(DetailActivity.EXTRA_alamatSEKOLAH,"Jl. Raya Imam Bonjol, Perumahan Telaga Sakinah, Desa Telagamurni, Kecamatan Cikarang Barat, Kabupaten Bekasi, Provinsi Jawa Barat 17530.")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_contactSEKOLAH,"Unknown")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_kegiatanSEKOLAH1, R.drawable.smk_kesehatan_el_hurriyah_1)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_kegiatanSEKOLAH2, R.drawable.smk_kesehatan_el_hurriyah_2)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_akreditasiSEKOLAH,"A")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_jurusanSEKOLAH,"Keperawatan")
                startActivity(pindahDataIntent)
            }
            "SMK LABORATORIUM GLOBAL" -> {
                val pindahDataIntent = Intent(this@MainActivity, DetailActivity::class.java)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_judul,"SMK Laboratorium Global")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_namaSEKOLAH,"SMK Laboratorium Global")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_coverSEKOLAH, R.drawable.smk_laboratorium_global_cover)
                pindahDataIntent.putExtra(
                    DetailActivity.EXTRA_deskripsiSEKOLAH,"""
                    SMK LABORATORIUM GLOBAL suatu sekolah yang terletak di Jl. Ki Hajar Dewantara No.21, Kelurahan Karangasih, Kecamatan Cikarang Utara
                    sekolah yang berstatus swasta ini memiliki 6 jurusan didalamnya yakni :
                    Administrasi
                    Administrasi Perkantoran
                    Manajemen Perkantoran
                    Teknik Kenderaan Ringan (B)
                    Teknik Mesin
                    Teknik Otomotif
                    Teknik Pemesinan
                """.trimIndent())
                pindahDataIntent.putExtra(DetailActivity.EXTRA_alamatSEKOLAH,"Jl. Raya Cikarang-Lemahabang, Kp. Kaliulu, Desa Karangraharja, Kecamatan Cikarang Utara, Kabupaten Bekasi, Provinsi Jawa Barat 17530,")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_contactSEKOLAH,"unknown")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_kegiatanSEKOLAH1, R.drawable.smk_lab_glob_1)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_kegiatanSEKOLAH2, R.drawable.smk_lab_glob_2)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_akreditasiSEKOLAH,"unknown")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_jurusanSEKOLAH,"Teknik Kendaraan Ringan")
                startActivity(pindahDataIntent)
            }
            "SMK PUJA MAHARDIKA" -> {
                val pindahDataIntent = Intent(this@MainActivity, DetailActivity::class.java)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_judul,"SMK Puja Mahardika")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_namaSEKOLAH,"SMK Puja Mahardika")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_coverSEKOLAH, R.drawable.smk_puja_mahardika_cover)
                pindahDataIntent.putExtra(
                    DetailActivity.EXTRA_deskripsiSEKOLAH,"""
                    SMK PUJA MAHARDIKA suatu sekolah yang terletak di Jl. Raya Cikarang-Lemahabang, Kp. Kaliulu, Desa Karangraharja, Kecamatan Cikarang Utara
                    sekolah yang berstatus swasta ini memiliki 6 jurusan didalamnya yakni :
                    Administrasi
                    Administrasi Perkantoran
                    Manajemen Perkantoran
                    Teknik Kenderaan Ringan (B)
                    Teknik Mesin
                    Teknik Otomotif
                    Teknik Pemesinan
                """.trimIndent())
                pindahDataIntent.putExtra(DetailActivity.EXTRA_alamatSEKOLAH,"Jl. Ki Hajar Dewantara No.21, Kelurahan Karangasih, Kecamatan Cikarang Utara, Kabupaten Bekasi, Provinsi Jawa Barat 17530")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_contactSEKOLAH,"unknown")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_kegiatanSEKOLAH1, R.drawable.smk_puja_mahardika_1)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_kegiatanSEKOLAH2, R.drawable.smk_puja_mahardika_2)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_akreditasiSEKOLAH,"B")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_jurusanSEKOLAH,"Teknik Kendaraan Ringan")
                startActivity(pindahDataIntent)
            }
            "SMK Perguruan Rakyat 2" -> {
                val pindahDataIntent = Intent(this@MainActivity, DetailActivity::class.java)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_judul,"SMK Perguruan Rakyat 2")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_namaSEKOLAH,"SMK Perguruan Rakyat 2")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_coverSEKOLAH, R.drawable.smkpr2_1)
                pindahDataIntent.putExtra(
                    DetailActivity.EXTRA_deskripsiSEKOLAH,"""
                    SMK Perguruan Rakyat 2 suatu sekolah yang terletak di Jl.AD Lampiri Pondok Kelapa RT/RW: 4/12 yang didirikan 2014-01-09 oleh bpk.H.Rizal Sudarmadi,SH, sekolah yang satu ini sangat lengkat dengan sopan, santun, sapa, salam. Sekolah ini juga akan mengajarkan kamu agar menjadi santun dalam menjadi siswa, seperti semboyannya Mencetak Generasi Berakhlak Mulia
                """.trimIndent())
                pindahDataIntent.putExtra(DetailActivity.EXTRA_alamatSEKOLAH,"Jl.AD Lampiri 28 Kel: Pondok Kelapa, Kec: Duren Sawit Provinsi: D.K.I.JAKARTA")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_contactSEKOLAH,"087783791277")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_kegiatanSEKOLAH1, R.drawable.smk_pr2_1)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_kegiatanSEKOLAH2, R.drawable.smkpr2_2)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_akreditasiSEKOLAH,"B")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_jurusanSEKOLAH,"Teknik Komputer Jaringan")
                startActivity(pindahDataIntent)
            }
            "SMK KESEHATAN SENTRA MEDIKA" -> {
                val pindahDataIntent = Intent(this@MainActivity, DetailActivity::class.java)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_judul,"SMK Kesehatan Sentra Medika")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_namaSEKOLAH,"SMK Kesehatan Sentra Medika")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_coverSEKOLAH, R.drawable.smk_kesehatan_sentra_medika_cover)
                pindahDataIntent.putExtra(
                    DetailActivity.EXTRA_deskripsiSEKOLAH,"""
                    SMK KESEHATAN SENTRA MEDIKA suatu sekolah yang terletak di Jl. Industri Pasir Gombong, Pasirgombong, Kec. Cikarang
                    sekolah yang berstatus swasta ini memiliki 6 jurusan didalamnya yakni :
                    Keperwatan 
                    Farmasi
                """.trimIndent())
                pindahDataIntent.putExtra(DetailActivity.EXTRA_alamatSEKOLAH,"Jl. Jenggolo No.2A, Siwalanpanji, Buduran, Kabupaten Sidoarjo, Jawa Timur 61219")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_contactSEKOLAH,"(021) 8904160")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_kegiatanSEKOLAH1, R.drawable.smk_kesehatan_sentra_medika_1)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_kegiatanSEKOLAH2, R.drawable.smk_kesehatan_sentra_medika_2)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_akreditasiSEKOLAH,"A")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_jurusanSEKOLAH,"Keperwatan")
                startActivity(pindahDataIntent)
            }
            "SMKN 2 Buduran Sidoarjo" -> {
                val pindahDataIntent = Intent(this@MainActivity, DetailActivity::class.java)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_judul,"SMKN 2 Buduran Sidoarjo")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_namaSEKOLAH,"SMKN 2 Buduran Sidoarjo")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_coverSEKOLAH, R.drawable.smkn_2_buduran_cover)
                pindahDataIntent.putExtra(
                    DetailActivity.EXTRA_deskripsiSEKOLAH,"""
                    SMKN 2 Buduran Sidoarjo suatu sekolah yang terletak di Jl. Jenggolo No.2A, Siwalanpanji, Buduran, Kabupaten Sidoarjo, Jawa Timur 61219
                    sekolah yang berstatus swasta ini memiliki 6 jurusan didalamnya yakni :
                    Akutansi
                    Bisnis Ritel
                    Multimedia
                    Rekayasa Perangkat Lunak
                    Perbankan
                """.trimIndent())
                pindahDataIntent.putExtra(DetailActivity.EXTRA_alamatSEKOLAH,"Jl. Jenggolo No.2A, Siwalanpanji, Buduran, Kabupaten Sidoarjo, Jawa Timur 61219")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_contactSEKOLAH,"(031) 8964034")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_kegiatanSEKOLAH1, R.drawable.smkn_2_buduran_1)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_kegiatanSEKOLAH2, R.drawable.smkn_2_buduran_2)
                pindahDataIntent.putExtra(DetailActivity.EXTRA_akreditasiSEKOLAH,"A")
                pindahDataIntent.putExtra(DetailActivity.EXTRA_jurusanSEKOLAH,"Rekayasa Perangkat Lunak")
                startActivity(pindahDataIntent)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int){
        when(selectedMode){
            R.id.Tentang -> {
                val tentang = Intent(this@MainActivity, AboutActivity::class.java)
                tentang.putExtra(AboutActivity.EXTRA_judul,"Tentang")
                startActivity(tentang)
            }
        }
    }
}