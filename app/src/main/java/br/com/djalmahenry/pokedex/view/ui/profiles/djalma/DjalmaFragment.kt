package br.com.djalmahenry.pokedex.view.ui.profiles.djalma

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.djalmahenry.pokedex.R
import br.com.djalmahenry.pokedex.databinding.CustomPopupDjalmaBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import android.app.AlertDialog as AlertDialog1

class DjalmaFragment : Fragment() {
    private lateinit var djalmaViewModel: DjalmaViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        djalmaViewModel = ViewModelProvider(this).get(DjalmaViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_djalma, container, false)

        val textViewDjalma: TextView = root.findViewById(R.id.text_djalma)
        djalmaViewModel.djalma.observe(viewLifecycleOwner, Observer {
            textViewDjalma.text = it
        })

        val textViewInfos: TextView = root.findViewById(R.id.text_infos)
        djalmaViewModel.infos.observe(viewLifecycleOwner, Observer {
            textViewInfos.text = it
        })

        val buttonMoreInfo: Button = root.findViewById(R.id.button_more)
        buttonMoreInfo.setOnClickListener { showCustomPopup() }

        val buttonPortfolio: Button = root.findViewById(R.id.button_portfolio)
        buttonPortfolio.setOnClickListener { view ->
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://portfolio.djalmahenry.com/")
                )
            )
        }

        val buttonLinkedin: Button = root.findViewById(R.id.button_linkedin)
        buttonLinkedin.setOnClickListener { view ->
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.linkedin.com/in/djalmahenry/")
                )
            )
        }

        val buttonInstagram: Button = root.findViewById(R.id.button_instagram)
        buttonInstagram.setOnClickListener { view ->
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/djalmahenry/")
                )
            )
        }

        return root
    }

    private fun showCustomPopup() {
        val dialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialog)

        val popupBinding: CustomPopupDjalmaBinding =
            CustomPopupDjalmaBinding.inflate(layoutInflater, null, false)

        val root = popupBinding.root

        val textViewTitle: TextView = root.findViewById(R.id.text_title)
        djalmaViewModel.titlePopup.observe(viewLifecycleOwner, Observer {
            textViewTitle.text = it
        })

        val textViewAboutOne: TextView = root.findViewById(R.id.text_about_one)
        djalmaViewModel.contentPopupOne.observe(viewLifecycleOwner, Observer {
            textViewAboutOne.text = it
        })

        val textViewAboutTwo: TextView = root.findViewById(R.id.text_about_two)
        djalmaViewModel.contentPopupTwo.observe(viewLifecycleOwner, Observer {
            textViewAboutTwo.text = it
        })

        dialog.setContentView(popupBinding.root)
        dialog.show()
    }
}