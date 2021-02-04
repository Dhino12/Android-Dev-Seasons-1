package com.example.mysubmission

import com.aplikasi.myapplication13.Sekolah


object SekolahData{
    private val sekolahName = arrayOf(
        "SMK TEKNOLOGI PELITA KARYA",
        "SMK AMANAH BANGSA",
        "SMK IT BINA MADANI",
        "SMK ISLAM AL-MUHAJIRIN",
        "SMK 11 Maret Cikarang",
        "SMK KESEHATAN EL-HURRIYAH",
        "SMK LABORATORIUM GLOBAL",
        "SMK PUJA MAHARDIKA",
        "SMK Perguruan Rakyat 2",
        "SMK KESEHATAN SENTRA MEDIKA",
        "SMKN 2 Buduran Sidoarjo"
    )
    private val sekolahAkreditasi = arrayOf(
        "Akreditasi: B",
        "Akreditasi: A",
        "Akreditasi: Unknown",
        "Akreditasi: A",
        "Akreditasi: A",
        "Akreditasi: A",
        "Akreditasi: Unknown",
        "Akreditasi: B",
        "Akreditasi: B",
        "Akreditasi: A",
        "Akreditasi: A"
    )
    private val sekolahJurusan = arrayOf(
        "Jurusan: Akutansi",
        "Jurusan: Multimedia",
        "Jurusan: Manajemen",
        "Jurusan: Teknik Kendaraan Ringan",
        "Jurusan: Akutansi",
        "Jurusan: Farmasi",
        "Jurusan: Teknik Kendaraan Ringan",
        "Jurusan: Administrasi Perkantoran",
        "Jurusan: Multimedia",
        "Jurusan: Teknik Komputer Jaringan",
        "Jurusan: Keperawatan",
        "Jurusan: Rekayasa Perangkat Lunak"
    )
    private val sekolahDetail = arrayOf(
        "Sekolah Swasta yang memiliki jurusan akutansi dengan akreditasi A",
        "Sekolah Swasta yang memiliki Multimedia untuk design dll",
        "Sekolah Swasta yang memiliki jurusan Manajemen yang diperlukan di perusahaan",
        "Sekolah Swasta dengan jurusan akutansi yang penuh dengan perhitungan",
        "Sekolah Swasta yang memiliki jurusan farmasi, dll",
        "Sekolah Swasta yang memiliki jurusan TKR yang berniat menjadi otomotif",
        "Sekolah Swasta yang memiliki jurusan administrasi perkantoran",
        "Sekolah Swasta yang memiliki jurusan multimedia design",
        "Sekolah Swasta yang terletak diPondokGede Kota Bekasi",
        "Sekolah Swasta yang terletak diCikarang dengan jurusan Keperawatan dan farmasi1",
        "Sekolah Negeri yang memiliki jurusan RPL untuk dunia kerja"
    )
    private val sekolahImage = intArrayOf(
        R.drawable.smk_teknologi_pelitakarya_logo,
        R.drawable.smk_amanah_bangsa,
        R.drawable.smk_bina_madani_logo,
        R.drawable.smk_al_muhajirin_logo,
        R.drawable.smk_11_maret_logo,
        R.drawable.smk_el_hurriyah_logo,
        R.drawable.smk_lab_glob_logo,
        R.drawable.smk_puja_mahardika_logo,
        R.drawable.pr2_logo,
        R.drawable.smk_medika_logo,
        R.drawable.smkn_2_buduran_sidoarjo
    )
    val listData: ArrayList<Sekolah>
        get() {
            val list = arrayListOf<Sekolah>()
                for (position in sekolahName.indices){
                    val sekolah = Sekolah()
                    sekolah.nama = sekolahName[position]
                    sekolah.photo = sekolahImage[position]
                    sekolah.detail = sekolahDetail[position]
                    sekolah.jurusan = sekolahJurusan[position]
                    sekolah.akreditasi = sekolahAkreditasi[position]
                    list.add(sekolah)
                }
            return list
        }
}