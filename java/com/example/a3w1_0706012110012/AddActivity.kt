package com.example.a3w1_0706012110012

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.a3w1_0706012110012.Model.Hewan
import com.example.a3w1_0706012110012.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    private lateinit var viewBind: ActivityAddBinding
    private lateinit var listHewan: Hewan
    var position = -1
    var image: String = ""

    private val GetResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == RESULT_OK){
            val uri = it.data?.data
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                if(uri != null){
                    baseContext.getContentResolver().takePersistableUriPermission(uri,
                        Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
                    )
                }}
            viewBind.addimage.setImageURI(uri)
            image = uri.toString()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind = ActivityAddBinding.inflate(layoutInflater)
        setContentView(viewBind.root)
        supportActionBar?.hide()
        getintent()
        listener()
    }
    private fun getintent(){
        position = intent.getIntExtra("position", -1)
        if(position != -1){
            val listHewan = Data.listHewan[position]
            viewBind.toolbar3.title = "Edit hewan"
            viewBind.saveBut.text = "Edit"
            viewBind.addimage.setImageURI(Uri.parse(Data.listHewan[position].imageUri))
            viewBind.namaH.editText?.setText(listHewan.namaH)
            viewBind.usiaH.editText?.setText(listHewan.usiaH)
            viewBind.jenisH.editText?.setText(listHewan.jenisH)
        }
    }
    private fun listener(){
        viewBind.addimage.setOnClickListener{
            val myIntent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            myIntent.type = "image/*"
            GetResult.launch(myIntent)
        }

        viewBind.saveBut.setOnClickListener{
            var namaHwn = viewBind.namaH.editText?.text
            var usiaHwn = viewBind.usiaH.editText?.text
            var jenisHwn = viewBind.jenisH.editText?.text

            listHewan = Hewan(namaHwn.toString(), usiaHwn.toString(), jenisHwn.toString())
            checker()
            finish()
        }

        viewBind.toolbar3.getChildAt(1).setOnClickListener {
            finish()
        }
    }

    private fun checker() {
        var isCompleted:Boolean = true

        if(listHewan.namaH!!.isEmpty()){
            viewBind.namaH.error = "Name cannot be empty"
            isCompleted = false
        }else{
            viewBind.namaH.error = ""
        }

        if(listHewan.usiaH!!.isEmpty()){
            viewBind.usiaH.error = "Age cannot be empty"
            isCompleted = false
        }else{
            viewBind.usiaH.error = ""
        }

        if(listHewan.jenisH!!.isEmpty()){
            viewBind.jenisH.error = "Type cannot be empty"
            isCompleted = false
        }else{
            viewBind.jenisH.error = ""
        }
    }
}

