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

    private val _titlePopup = MutableLiveData<String>().apply {
        value = "Sobre mim"
    }
    val titlePopup: LiveData<String> = _titlePopup

    private val _contentPopupOne = MutableLiveData<String>().apply {
        value = "Desde pequeno, sempre fui fascinado pelas novas tecnologias que saiam no mercado, " +
                "desde smartphones até video games. Comecei a programar aos 13 anos fazendo servidores " +
                "de minecraft onde eu fazia plugins em java para jogar com meus amigos."
    }
    val contentPopupOne: LiveData<String> = _contentPopupOne

    private val _contentPopupTwo = MutableLiveData<String>().apply {
        value = "Este ano, pretendo aprimorar mais meus conhecimentos nas tecnologias que já trabalho " +
                "e também explorar mais o mundo mobile. E claro, pretendo curtir a vida e levar a programação " +
                "sempre good vibes, assim como sempre foi para mim."
    }
    val contentPopupTwo: LiveData<String> = _contentPopupTwo
}