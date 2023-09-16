package com.example.superhero

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListFragment : Fragment() {

    private var onItemClick: (String) -> Unit = {}

    val api = ApiClient.client.create(ApiInterface::class.java)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment_layout, container, false)
    }

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listView: RecyclerView = view.findViewById(R.id.recycleView)
        api.getSuperhero()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it.isNotEmpty()) {
                    val superheroes = it
                    val myAdapter = SuperheroAdapter(superheroes, {})
                    listView.adapter = myAdapter
                }
            }, {
//                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            })
        listView.layoutManager = LinearLayoutManager(requireContext())
    }
}