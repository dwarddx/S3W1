package com.example.a3w1_0706012110012

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.a3w1_0706012110012.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity(), cardListener{
    private lateinit var viewBind:ActivityHomeBinding
    private val adapter = RVAdapter(Data.listHewan)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBind.root)
        supportActionBar?.hide()
        setupRecyclerView()
        datahewan()
    }

    private fun datahewan(){
        viewBind.addAnimal.setOnClickListener {
            val pindahinput = Intent(this, AddActivity::class.java)
            startActivity(pindahinput)
        }
    }

    private fun setupRecyclerView(){
        val layoutManager = GridLayoutManager(this,2)
        viewBind.recyclerView.layoutManager = layoutManager   // Set layout
        viewBind.recyclerView.adapter = adapter   // Set adapter
    }

    override fun onCardClick(position: Int) {
    }

}