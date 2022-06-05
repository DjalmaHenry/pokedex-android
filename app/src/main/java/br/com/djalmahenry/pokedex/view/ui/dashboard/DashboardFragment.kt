package br.com.djalmahenry.pokedex.view.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.djalmahenry.pokedex.R
import br.com.djalmahenry.pokedex.api.PokemonRepository
import br.com.djalmahenry.pokedex.domain.Pokemon
import br.com.djalmahenry.pokedex.domain.PokemonType
import br.com.djalmahenry.pokedex.view.PokemonAdapter
import br.com.djalmahenry.pokedex.viewmodel.PokemonViewModel
import br.com.djalmahenry.pokedex.viewmodel.PokemonViewModelFactory

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var recyclerView: RecyclerView

    private val viewModel by lazy {
        ViewModelProvider(this, PokemonViewModelFactory())
            .get(PokemonViewModel::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        recyclerView = root.findViewById(R.id.rvPokemons)

        viewModel.pokemons.observe(viewLifecycleOwner, Observer {
            loadRecyclerView(it)
        })

        return root
    }

    private fun loadRecyclerView(pokemons: List<Pokemon?>) {
        recyclerView.layoutManager = LinearLayoutManager(getContext())
        recyclerView.adapter = PokemonAdapter(pokemons)
    }
}