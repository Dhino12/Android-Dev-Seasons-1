package com.example.mysubmission

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aplikasi.myapplication13.Sekolah
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListSekolahAdapter(val listSekolah: ArrayList<Sekolah>) : RecyclerView.Adapter<ListSekolahAdapter.ListViewHolder>(){
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }
    inner class ListViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvJurusan: TextView = itemView.findViewById(R.id.tv_jurusan)
        var tvAkreditasi: TextView = itemView.findViewById(R.id.tv_akreditasi)
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int
    ): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_sekolah,viewGroup,false )
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listSekolah.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val sekolah = listSekolah[position]
        Glide.with(holder.itemView.context)
            .load(sekolah.photo)
            .apply(RequestOptions().override(55,55))
            .into(holder.imgPhoto)
        holder.tvName.text = sekolah.nama
        holder.tvDetail.text = sekolah.detail
        holder.tvAkreditasi.text = sekolah.akreditasi
        holder.tvJurusan.text = sekolah.jurusan
        holder.itemView.setOnClickListener(){
            onItemClickCallback.onItemClicked(listSekolah[holder.adapterPosition])
        }
    }

    interface OnItemClickCallback{
        fun onItemClicked(data: Sekolah)
    }

}