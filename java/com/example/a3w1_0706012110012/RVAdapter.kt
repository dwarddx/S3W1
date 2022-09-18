package com.example.a3w1_0706012110012

//import android.net.Uri
//import android.system.Os.bind
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.a3w1_0706012110012.Model.Hewan
//
//class RVAdapter(val datahewan: ArrayList<Hewan>, val cardListener: CardListener):
//    RecyclerView.Adapter<RVAdapter.viewHolder>() {
//
////    class viewHolder(itemView: View, val cardListener1: CardListener): RecyclerView.ViewHolder(itemView) {
////        val binding = HomeActivity.bind(itemView)
////
////        fun setData(data: Hewan){
////            binding.namaH.text=data.namaH
////
////            if(!data.imageUri!!.isEmpty()){
////                binding.MovPosterView.setImageURI(Uri.parse(data.imageUri))
////            }
////            itemView.setOnClickListener{
////                cardListener1.onCardClick(adapterPosition)
////            }
////        }
////    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
//        val layoutInflater = LayoutInflater.from(parent.context)
//        val view = layoutInflater.inflate(R.layout.animal_views, parent, false)
//        return viewHolder(view, cardListener)
//    }
//
//    override fun onBindViewHolder(holder: viewHolder, position: Int) {
//        holder.setData(listHewan[position])
//    }
//
//    override fun getItemCount(): Int {
//        return listHewan.size
//    }
//}

//
//import com.example.a3w1_0706012110012.Model.Hewan
//import android.net.Uri
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.a3w1_0706012110012.databinding.ActivityMainBinding
//import com.example.kandangcrud.databinding.ActivityCardhewanBinding
//import java.util.*
//
//
//
//class RVAdapter (val listHewan: ArrayList<Hewan>):
//    RecyclerView.Adapter<RVAdapter.viewHolder>(){
//    class viewHolder (val itemView: View): RecyclerView.ViewHolder(itemView) {
//
//        val binding = ActivityMainBinding.bind(itemView)
//        fun setData(data: Hewan) {
//            binding.HewanCardNama.text = data.namaH
//            binding.HewanCardJenis.text = data.jenisH
//            binding.HewanCardUsia.text = data.usiaH.toString()
//            if (data.imageUri.isNotEmpty()) {
//                binding.HewanCardImage.setImageURI(Uri.parse(data.imageUri))
//            }
//            itemView.setOnClickListener {
//                cardListener1.pencetKartu(adapterPosition)
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
//        val layoutInflater = LayoutInflater.from(parent.context)
//        val view = layoutInflater.inflate(R.layout.activity_cardhewan, parent, false)
//        return viewHolder(view, cardListener)
//    }
//
//    override fun onBindViewHolder(holder: viewHolder, position: Int) {
//        holder.setData(listHewan[position])
//    }
//
//    override fun getItemCount(): Int {
//        return listHewan.size
//    }
//
//}

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a3w1_0706012110012.Model.Hewan

class RVAdapter(val dataHewan: MutableList<Hewan>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val namaHewan: TextView
        val jenisHewan: TextView
        val usiaHewan: TextView
        val editButton: Button
        val deleteButton: Button

        init {
            namaHewan = view.findViewById(R.id.namaHewan)
            usiaHewan = view.findViewById(R.id.usiaHewan)
            jenisHewan = view.findViewById(R.id.jenisHewan)
            editButton = view.findViewById(R.id.editB)
            deleteButton = view.findViewById(R.id.deleteB)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.animal_views,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.namaHewan.text = dataHewan.get(position).namaH
        holder.usiaHewan.text = dataHewan.get(position).usiaH.toString()
        holder.jenisHewan.text = dataHewan.get(position).jenisH
    }

    override fun getItemCount(): Int {
        return dataHewan.size
    }

}
