package com.example.mylibrary.adapter

import android.view.LayoutInflater
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.mylibrary.R
import com.example.mylibrary.entité.Livre
import kotlinx.android.synthetic.main.list_livre.view.*
class ListLivreAdapter(context: Context, var listLivreAdapter: ArrayList<Livre>) :
    BaseAdapter() {

    var context: Context?= context

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        var view=inflater.inflate(R.layout.list_livre,null)
        val livre=listLivreAdapter[position]
        view.titre_livre.text = livre.titre
        return view
    }

    override fun getItem(position: Int): Any {
        return listLivreAdapter[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return listLivreAdapter.size
    }
}