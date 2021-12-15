package kanda.lab.feature.home.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kanda.lab.feature.home.ui.R
import kanda.lab.feature.home.ui.databinding.ActivityMainBinding
import kanda.lab.feature.home.ui.databinding.FragmentCharacterListBinding

class CharacterListFragment : Fragment() {

    private val binding by lazy { FragmentCharacterListBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}