package com.example.mylibrary.entité

class Livre (cTitre:String, cAuteur: Auteur, cResume:String) {
    lateinit var titre :String
    lateinit var auteur: Auteur
    lateinit var resume:String
    init {
        titre = cTitre
        auteur = cAuteur
        resume = cResume
    }

}