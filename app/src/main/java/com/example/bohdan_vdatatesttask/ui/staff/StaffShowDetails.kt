package com.example.bohdan_vdatatesttask.ui.staff

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bohdan_vdatatesttask.R

class StaffShowDetails: AppCompatActivity() {
    private lateinit var name: String
    private lateinit var surname: String
    private lateinit var pic: String
    private lateinit var comp: String
    private lateinit var iw: ImageView

    private var imagesURL = arrayOf<String>("https://i.imgur.com/8u2bhLf.png",
        "https://i.imgur.com/OswijIJ.png",
        "https://i.imgur.com/Jao8Fyi.png",
        "https://i.imgur.com/pDQRaBm.png",
        "https://i.imgur.com/BdhGyQA.png",
        "https://i.imgur.com/0h7HmGZ.png",
        "https://i.imgur.com/tNRQnso.png",
        "https://i.imgur.com/YBuVlp7.png",
        "https://i.imgur.com/mZChCWF.png",
        "https://i.imgur.com/U0Tmjl9.png",
        "https://i.imgur.com/hkWikj6.png")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.staff_details)

        val intent: Intent = intent
        name = findViewById<TextView>(R.id.staff_name_view).text.toString() +
                intent.getStringExtra("staff_name").toString()
        surname = findViewById<TextView>(R.id.staff_surname_view).text.toString() +
                intent.getStringExtra("staff_surname").toString()
        pic = intent.getStringExtra("staff_pic").toString()
        comp = findViewById<TextView>(R.id.staff_comp_view).text.toString() +
                intent.getStringExtra("staff_comp").toString()
        val id: Long? = intent.getStringExtra("staff_id")?.toLong()

        val button: Button = findViewById(R.id.staff_edit)
        button.setOnClickListener {
            val dialog = StaffDialog(false, intent.getStringExtra("staff_name").toString(),
                intent.getStringExtra("staff_surname").toString(),
                intent.getStringExtra("staff_comp").toString(),
                pic, id)
            dialog.show(supportFragmentManager, "")
        }

        findViewById<TextView>(R.id.staff_name_view).text = name
        findViewById<TextView>(R.id.staff_surname_view).text = surname
        findViewById<TextView>(R.id.staff_comp_view).text = comp

        iw = findViewById(R.id.staff_pic_view)
        val imageDownload = StaffImagesDownload(this, null, iw)
        imageDownload.execute(imagesURL[pic.toInt()])
    }
}