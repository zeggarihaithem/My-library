package com.example.mylibrary

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.mylibrary.adapter.ListLivreAdapter
import com.example.mylibrary.data.ListLivre
import com.example.mylibrary.entité.Livre
import com.example.mylibrary.fragment.ListLivreFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       //land big screen
        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE && resources.getBoolean(
                R.bool.isTablet
            )) {
            val adapter= ListLivreAdapter(
                this.applicationContext,
                ListLivre.getLivre() as ArrayList<Livre>
            )
            land_list_livre.adapter=adapter
            land_list_livre.onItemClickListener =
                AdapterView.OnItemClickListener { arg0, arg1, position, arg3 ->
                    val livre: Livre = land_list_livre.adapter.getItem(position) as Livre
                    land_name_auteur.text = livre.auteur.name
                    land_auteur_image.setImageResource(livre.auteur.photo)
                    land_resume.text = livre.resume
                    details_layout.visibility = View.VISIBLE

                }

            Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show()
        }else{
            //petit screen
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(
                R.id.navigation_fragment,
                ListLivreFragment()
            )
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()


        }

    }


}
