package com.example.bohdan_vdatatesttask.ui.staff

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ProgressBar
import com.example.bohdan_vdatatesttask.R

class StaffImagesView: Activity() {
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
        setContentView(R.layout.images_staff)
        val c: Context = this
        val prDialog = ProgressBar(c, null, android.R.attr.progressBarStyleHorizontal)

        prDialog.isIndeterminate = false
        prDialog.visibility = ProgressBar.INVISIBLE

        val gridView = findViewById<GridView>(R.id.gridView)

        val downloadHandler =
            StaffImagesDownload(
                prDialog,
                c,
                gridView
            )
        downloadHandler.execute(*imagesURL)

        gridView.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, pos, _ ->
                val resultIntent = Intent()
                resultIntent.putExtra("message_return", pos.toString())
                setResult(0, resultIntent)
                onBackPressed()
            }
    }
}