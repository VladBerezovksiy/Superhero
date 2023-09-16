package com.example.superhero

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class SuperheroAdapter(private val superheroes: List<Superhero>) :
    RecyclerView.Adapter<SuperheroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val listItemViewHolder = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_layout, parent, false)
        return SuperheroViewHolder(listItemViewHolder)
    }

    override fun getItemCount(): Int = superheroes.size

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        holder.title.text = superheroes[position].name
        holder.work.text = superheroes[position].work.occupation
        Glide.with(holder.itemView)
            .load(superheroes[position].images.xs)
            .into(holder.image)

        holder.itemView.setOnClickListener {
            val mainActivity = it.context as AppCompatActivity
            val detailsFragment = DetailsFragment()
            detailsFragment.setSuperHero(superheroes[position])
            mainActivity.supportFragmentManager.beginTransaction()
                .add(R.id.list, detailsFragment)
                .addToBackStack("Details_Fragment")
                .commit()
        }
    }
}


class SuperheroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.findViewById(R.id.superheroName)
    val work: TextView = itemView.findViewById(R.id.superheroDesc)
    val image: ImageView = itemView.findViewById(R.id.superheroImage)
}