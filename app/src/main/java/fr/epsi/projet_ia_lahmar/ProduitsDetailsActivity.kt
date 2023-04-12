package fr.epsi.projet_ia_lahmar

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ProduitsDetailsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produits_details)
        showBack()
        val product = intent.getSerializableExtra("product") as? Produits
        setHeaderTitle("${product?.name}")

        val imageViewProduct = findViewById<ImageView>(R.id.productimage)
        Picasso.get().load(product?.picture_url).into(imageViewProduct)

        val textViewProductDescription = findViewById<TextView>(R.id.productDescription)
        textViewProductDescription.text = "Descrption : "+product?.description
    }
}