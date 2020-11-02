package com.example.bohdan_vdatatesttask.ui.staff

import android.content.Context
import android.graphics.Bitmap
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.ImageView

class StaffImagesAdapter(c: Context, list: MutableList<Bitmap?>): BaseAdapter() {
    private var context: Context = c
    private var imageList: List<Bitmap?> = list

    override fun getView(pos: Int, conv: View?, parent: ViewGroup?): View {
        lateinit var imageView: ImageView

        if(conv == null){
            imageView = ImageView(context)
            imageView.layoutParams = AbsListView.LayoutParams(120, 120)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(5, 5, 5, 5)
        }
        else {
            imageView = conv as ImageView
        }
        imageView.setImageBitmap(imageList[pos])
        return imageView
    }

    override fun getItem(p0: Int): Bitmap? {
        return imageList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return imageList.size
    }
}