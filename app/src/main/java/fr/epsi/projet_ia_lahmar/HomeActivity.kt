package fr.epsi.projet_ia_lahmar

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class HomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setHeaderTitle(getString(R.string.txt_title_epsi))

        val buttonInfo = findViewById<Button>(R.id.buttonInfo)
        buttonInfo.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, infoActivity::class.java)
            newIntent.putExtra("title", getString(R.string.txt_info))
            startActivity(newIntent)
        })

        val buttonProduits = findViewById<Button>(R.id.buttonProduits)
        buttonProduits.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, CategoriesActivity::class.java)
            startActivity(newIntent)
        })
    }
}