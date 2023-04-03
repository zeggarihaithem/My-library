package com.example.mylibrary.data

import com.example.mylibrary.R
import com.example.mylibrary.entité.Auteur
import com.example.mylibrary.entité.Livre

class ListLivre {
    companion object {
        fun getLivre(): List<Livre> {
            //  getApplicationContext().getPackageName();
            val listLivre = ArrayList<Livre>()
            listLivre.add(
                Livre(
                    "livre1",
                    Auteur(
                        "Auteur1",
                        R.mipmap.ic_auteur
                    ),
                    "cette paragraphe est le réumé1"
                )
            )
            listLivre.add(
                Livre(
                    "livre2",
                    Auteur(
                        "Auteur2",
                        R.mipmap.ic_auteur
                    ),
                    "cette paragraphe est le réumé2"
                )
            )
            return listLivre
        }

    }
}