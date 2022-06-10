package br.com.djalmahenry.pokedex.view.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import br.com.djalmahenry.pokedex.R
import br.com.djalmahenry.pokedex.view.ui.home.HomeFragment


class AboutFragment : Fragment() {

    private lateinit var aboutViewModel: AboutViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        aboutViewModel = ViewModelProvider(this).get(AboutViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_about, container, false)
        val textView: TextView = root.findViewById(R.id.title_about)
        aboutViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        val cardView: CardView = root.findViewById(R.id.cardView_djalma)
        cardView.setOnClickListener { v ->
            Navigation.findNavController(v).navigate(R.id.navigation_djalma)
        }
        return root
    }
}