package br.com.djalmahenry.pokedex.view.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.djalmahenry.pokedex.R
import br.com.djalmahenry.pokedex.domain.Pokemon
import br.com.djalmahenry.pokedex.domain.PokemonType
import br.com.djalmahenry.pokedex.view.PokemonAdapter

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val recyclerView = root.findViewById<RecyclerView>(R.id.rvPokemons)

        val charmander = Pokemon(
            "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/004.png",
            1,
            "Charmander",
            listOf(PokemonType("Fire"))
        )
        val pokemons = listOf(charmander, charmander, charmander, charmander)
        val layoutManager = LinearLayoutManager(getContext())
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = PokemonAdapter(pokemons)
        //val textView: TextView = root.findViewById(R.id.text_dashboard)
        //dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
        //    textView.text = it
        //})
        return root
    }
}