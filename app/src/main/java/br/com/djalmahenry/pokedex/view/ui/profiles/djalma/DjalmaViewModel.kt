package br.com.djalmahenry.pokedex.view.ui.profiles.djalma

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DjalmaViewModel : ViewModel() {

    private val _djalma = MutableLiveData<String>().apply {
        value = "Djalma Henrique"
    }
    val djalma: LiveData<String> = _djalma

    private val _infos = MutableLiveData<String>().apply {
        value = "Estudante de Ciência da computação e " +
                "Desenvolvedor Web e Mobile Full Stack"
    }
    val infos: LiveData<String> = _infos
}