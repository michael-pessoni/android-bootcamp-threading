package com.everis.bootcamp.threading

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_load.setOnClickListener {
            launchTaskAstro()
        }
    }


    private fun showData(list: List<AstroPeople>?) {
        textview_data.text = ""
        list?.forEach { people ->
            textview_data.append("${people.name} - ${people.craft} \n\n")
        }
    }


    private fun showProgress(isLoading: Boolean) {
        progressbar_load_indicator.visibility = if (isLoading) View.VISIBLE else View.GONE
    }


    private fun launchTaskAstro() {
        TaskAstro().execute()

    }




    inner class TaskAstro() : AsyncTask<Void, Int, List<AstroPeople>>(){
        private val repository = AstroRepository()

        override fun onPreExecute() {
            super.onPreExecute()
            showProgress(true)
        }

        override fun doInBackground(vararg p0: Void?): List<AstroPeople>? {
            val result = repository.loadData()
            return result?.people
        }

        override fun onPostExecute(result: List<AstroPeople>?) {
            super.onPostExecute(result)
            showProgress(false)
            showData(result)
        }

    }

}
