package fr.epsi.projet_ia_lahmar

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("EPSI IA Project","################ onCreate :"+javaClass.simpleName)
    }

    override fun onStart() {
        super.onStart()
        Log.e("EPSI IA Project","################ onStart :"+javaClass.simpleName)
    }

    override fun onResume() {
        super.onResume()
        Log.e("EPSI IA Project","################ onResume :"+javaClass.simpleName)
    }

    override fun onPause() {
        super.onPause()
        Log.e("EPSI IA Project","################ onPause :"+javaClass.simpleName)
    }

    override fun onStop() {
        super.onStop()
        Log.e("EPSI IA Project","################ onStop :"+javaClass.simpleName)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("EPSI IA Project","################ onDestroy :"+javaClass.simpleName)
    }

    fun setHeaderTitle( title:String?){
        val textViewTitle= findViewById<TextView>(R.id.textViewTitle)
        textViewTitle.setText(title)
    }

    fun showBack() {
        val imageViewBack = findViewById<ImageView>(R.id.imageViewBack)
        imageViewBack.visibility = View.VISIBLE
        imageViewBack.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

}