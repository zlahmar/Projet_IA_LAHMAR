package fr.epsi.projet_ia_lahmar

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProduitsAdapter (private val products: ArrayList<Produits>): RecyclerView.Adapter<ProduitsAdapter.ViewHolder>() {
    class ViewHolder(view: View) :RecyclerView.ViewHolder(view){
        val textViewProductName: TextView = view.findViewById(R.id.textViewProductName)
        val textViewProductDescription: TextView = view.findViewById(R.id.textViewProductDescription)
        val imageViewProduct: ImageView = view.findViewById(R.id.imageViewProduct)
        val layoutContent: LinearLayout = view.findViewById(R.id.layoutContentCategoryItem)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_produitslist, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.textViewProductName.text=product.name
        holder.textViewProductDescription.text="Description: "+product.description
        Picasso.get().load(product.picture_url).into(holder.imageViewProduct)
        holder.layoutContent.setOnClickListener(View.OnClickListener {
            val intent = Intent(holder.layoutContent.context, ProduitsDetailsActivity::class.java)
            intent.putExtra("Produit", product)
            holder.layoutContent.context.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return products.size
    }

}