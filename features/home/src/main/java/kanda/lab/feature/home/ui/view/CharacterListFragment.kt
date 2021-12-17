package kanda.lab.feature.home.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kanda.lab.domain.Character
import kanda.lab.feature.home.ui.adapter.CharacterListAdapter
import kanda.lab.feature.home.ui.databinding.FragmentCharacterListBinding
import kanda.lab.feature.home.ui.viewModel.CharacterViewModel

@AndroidEntryPoint
class CharacterListFragment() : Fragment(){

    private val viewModel by lazy {
        ViewModelProvider(this)[CharacterViewModel::class.java]
    }
    private val characterAdapter by lazy {
        CharacterListAdapter()
    }
    private val binding by lazy { FragmentCharacterListBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadCharacter()
        viewModel.listOfCharacter.observe(viewLifecycleOwner,{characters ->
            loadRecycleView(characters)
        })
    }

    private fun loadRecycleView(characters: List<Character>) {
        binding.listCharacteres.adapter = characterAdapter
        binding.listCharacteres.layoutManager = GridLayoutManager(view?.context,2)
        characterAdapter.submitList(characters)
    }
}