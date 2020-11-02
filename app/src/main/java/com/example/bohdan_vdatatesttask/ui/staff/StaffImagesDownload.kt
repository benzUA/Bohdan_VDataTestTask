package com.example.bohdan_vdatatesttask.ui.staff

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ProgressBar
import java.io.BufferedInputStream
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL


class StaffImagesDownload(progressDialog: ProgressBar, c: Context, gw: GridView): AsyncTask<String, Void, MutableList<Bitmap?>>() {
    private var prBar = progressDialog
    private var context: Context = c
    private var gridView: GridView = gw

    override fun onPreExecute() {
        prBar.visibility = ProgressBar.VISIBLE
    }

    override fun doInBackground(vararg urls: String?): MutableList<Bitmap?> {
        val count: Int = urls.size
        var connection: HttpURLConnection? = null
        val bitmaps: MutableList<Bitmap?> = ArrayList()
        var urlsNew: MutableList<URL?> = mutableListOf()

        for(i in urls.indices){
            urlsNew.add(stringToURL(urls[i]))
        }

        for (i in 0 until count) {
            val currentURL: URL? = urlsNew[i]
            try {
                connection = currentURL?.openConnection() as HttpURLConnection
                connection.connect()
                val inputStream: InputStream = connection.inputStream
                val bufferedInputStream = BufferedInputStream(inputStream)
                val bmp = BitmapFactory.decodeStream(bufferedInputStream)
                bitmaps.add(bmp)

                if (isCancelled) {
                    break
                }
            } catch (e: IOException) {
                e.printStackTrace()
            } finally {
                connection?.disconnect()
            }
        }
        return bitmaps
    }

    override fun onPostExecute(result: MutableList<Bitmap?>) {
        prBar.visibility = ProgressBar.INVISIBLE
        val imagesAdapter: BaseAdapter = StaffImagesAdapter(context, result)

        gridView.adapter = imagesAdapter
    }

    private fun stringToURL(urlString: String?): URL? {
        try {
            return URL(urlString)
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        }
        return null
    }
}