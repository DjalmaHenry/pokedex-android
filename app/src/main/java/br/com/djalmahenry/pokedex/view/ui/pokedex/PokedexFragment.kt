package br.com.djalmahenry.pokedex.view.ui.pokedex

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.djalmahenry.pokedex.R
import br.com.djalmahenry.pokedex.domain.Pokemon
import br.com.djalmahenry.pokedex.view.PokemonAdapter

class PokedexFragment : Fragment() {

    private lateinit var pokedexViewModel: PokedexViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var loadingImageView:ImageView
    private lateinit var loadingTextView:TextView

    private val viewModel by lazy {
        ViewModelProvider(this, PokedexViewModelFactory())
            .get(PokedexViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pokedexViewModel = ViewModelProvider(this).get(PokedexViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_pokedex, container, false)
        recyclerView = root.findViewById(R.id.rvPokemons)
        loadingImageView = root.findViewById(R.id.loading_image_view)
        loadingImageView.setVisibility(View.VISIBLE)
        loadingTextView = root.findViewById(R.id.loading_text_view)
        loadingTextView.setVisibility(View.VISIBLE)

        viewModel.pokemons.observe(viewLifecycleOwner, Observer {
            loadRecyclerView(it)
            loadingTextView.setVisibility(View.GONE)
            loadingImageView.setVisibility(View.GONE)
        })

        return root
    }

    private fun loadRecyclerView(pokemons: List<Pokemon?>) {
        recyclerView.layoutManager = LinearLayoutManager(getContext())
        recyclerView.adapter = PokemonAdapter(pokemons)
    }
}