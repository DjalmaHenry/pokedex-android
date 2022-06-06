package br.com.djalmahenry.pokedex.view.ui.profiles.djalma

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DjalmaViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Djalma Henrique"
    }
    val text: LiveData<String> = _text
}