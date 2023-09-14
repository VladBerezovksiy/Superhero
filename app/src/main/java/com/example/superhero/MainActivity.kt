package com.example.superhero

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        val listFragment = supportFragmentManager.findFragmentById(R.id.list) as ListFragment
        val detailsFragment =
            supportFragmentManager.findFragmentById(R.id.detailsTitle) as? DetailsFragment
        listFragment.setItemClickListener {
            if (detailsFragment != null) {
                detailsFragment.description = it
                detailsFragment.show()
            } else {
                val detailsFragment = DetailsFragment()
                detailsFragment.description = it
                supportFragmentManager.beginTransaction()
                    .add(R.id.list, detailsFragment)
                    .addToBackStack("details_fragment")
                    .commit()
            }
        }
    }
}

data class Superhero(val name: String, val images: Images)
data class Images(val xs: String)