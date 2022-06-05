package br.com.djalmahenry.pokedex.view.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Encontre todos os seus Pokémons favoritos."
    }
    val text: LiveData<String> = _text
}