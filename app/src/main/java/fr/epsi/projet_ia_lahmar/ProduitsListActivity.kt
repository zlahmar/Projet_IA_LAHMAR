package fr.epsi.projet_ia_lahmar

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ProduitsListActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produits_list)
        showBack()
        val category = intent.getSerializableExtra("category") as? Categories
        setHeaderTitle("${category?.title}")

        val products= arrayListOf<Produits>()

        val recyclerviewProducts=findViewById<RecyclerView>(R.id.recyclerviewProduits)
        recyclerviewProducts.layoutManager= LinearLayoutManager(this)
        val productAdapter=ProduitsAdapter(products)
        recyclerviewProducts.adapter=productAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL="https://www.ugarit.online/epsi/drink.json"
        val request = mRequestURL?.let {
            Request.Builder()
                .url(it)
                .get()
                .cacheControl(CacheControl.FORCE_NETWORK)
                .build()
        }

        request?.let {
            okHttpClient.newCall(it).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    TODO("Not yet implemented")
                }

                override fun onResponse(call: Call, response: Response) {
                    val data = response.body?.string()

                    if(data!=null) {
                        val jsProducts = JSONObject(data)
                        val jsArrayProducts = jsProducts.getJSONArray("items")
                        for (i in 0 until jsArrayProducts.length()) {
                            val js = jsArrayProducts.getJSONObject(i)
                            val product = Produits(
                                js.optString("name", "not found"),
                                js.optString("description", "not found"),
                                js.optString("picture_url", "not found"),
                            )
                            products.add(product)
                            runOnUiThread(Runnable {
                                productAdapter.notifyDataSetChanged()
                            })
                        }
                    }
                }
            })
        }

    }
}