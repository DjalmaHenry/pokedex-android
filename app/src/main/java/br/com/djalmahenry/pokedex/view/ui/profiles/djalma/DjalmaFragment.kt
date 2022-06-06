package br.com.djalmahenry.pokedex.view.ui.profiles.djalma

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.djalmahenry.pokedex.R

class DjalmaFragment : Fragment() {
    private lateinit var djalmaViewModel: DjalmaViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        djalmaViewModel = ViewModelProvider(this).get(DjalmaViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_djalma, container, false)
        val textView: TextView = root.findViewById(R.id.text_djalma)
        djalmaViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}