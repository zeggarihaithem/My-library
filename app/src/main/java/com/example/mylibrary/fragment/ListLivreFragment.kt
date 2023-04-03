package com.example.mylibrary.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.mylibrary.R
import com.example.mylibrary.adapter.ListLivreAdapter
import com.example.mylibrary.data.ListLivre
import com.example.mylibrary.entité.Livre
import kotlinx.android.synthetic.main.list_livre_fragment.*


class ListLivreFragment : Fragment() {

    companion object {
        fun newInstance() = ListLivreFragment()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_livre_fragment, container, false)
    }
    lateinit var titreView :TextView
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val adapter= ListLivreAdapter(
            context!!,
            ListLivre.getLivre() as ArrayList<Livre>
        )
        list_livre.adapter=adapter
        list_livre.onItemClickListener = OnItemClickListener { _, _, position, _ ->
            val detailLivreFragment =
                DetailLivreFragment()
            val livre: Livre = list_livre.adapter.getItem(position) as Livre
            val bundle = Bundle()
            bundle.putString("nomAuteur",livre.auteur.name)
            bundle.putInt("photoAuteur",livre.auteur.photo)
            bundle.putString("resume",livre.resume)
            detailLivreFragment.arguments = bundle
            replaceFragment(detailLivreFragment)
        }
 }
    private fun replaceFragment (fragment: Fragment){
        val fragmentTransaction = activity?.supportFragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.navigation_fragment , fragment)
        fragmentTransaction?.addToBackStack(null)
        fragmentTransaction?.commit()
    }


}
