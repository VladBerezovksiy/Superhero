package com.example.superhero

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SuperheroAdapter(
    private val superheroes: List<Superhero>, val callBack: (result: String) -> Unit
) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val listView = convertView ?: LayoutInflater.from(parent?.context)
            .inflate(R.layout.details_fragment_layout, parent, false)

        val nameTextView: TextView = listView.findViewById(R.id.detailsTitle)
        val imageView: ImageView = listView.findViewById(R.id.superheroImage)

        Glide.with(listView)
            .load(superheroes[position].images.xs)
            .into(imageView)

        nameTextView.text = superheroes[position].name
        return listView
    }

    override fun getCount(): Int = superheroes.size

    override fun getItem(position: Int): Superhero = superheroes[position]

    override fun getItemId(position: Int): Long = position.toLong()

}