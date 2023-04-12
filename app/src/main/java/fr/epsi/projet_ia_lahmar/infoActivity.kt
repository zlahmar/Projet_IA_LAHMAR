package fr.epsi.projet_ia_lahmar

import android.os.Bundle
class infoActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        showBack()
        setHeaderTitle(getString(R.string.txt_info))
    }
}