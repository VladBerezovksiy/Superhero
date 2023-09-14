package com.example.superhero

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailsFragment : Fragment() {

    private var detailsTitle: TextView? = null
    private lateinit var detailsImage: ImageView
    var description = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailsTitle = view.findViewById(R.id.detailsTitle)
        detailsImage = view.findViewById(R.id.superheroImage)
        detailsTitle?.text = description
    }

    fun show() {
        detailsTitle?.text = description
    }
}