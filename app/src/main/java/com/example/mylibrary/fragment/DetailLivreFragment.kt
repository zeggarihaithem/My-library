package com.example.mylibrary.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mylibrary.R
import kotlinx.android.synthetic.main.detail_livre_fragment.*


class DetailLivreFragment : Fragment() {

    companion object {
        fun newInstance() = DetailLivreFragment()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.detail_livre_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val bundle = arguments
        nom_auteur.text = bundle!!.getString("nomAuteur")
        auteur_image.setImageResource(bundle!!.getInt("photoAuteur"))
        resume.text = bundle!!.getString("resume")
    }

}
