package kanda.lab.feature.home.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kanda.lab.domain.model.Character
import kanda.lab.feature.home.ui.R
import kanda.lab.feature.home.ui.adapter.CharacterListAdapter
import kanda.lab.feature.home.ui.databinding.FragmentCharacterListBinding
import kanda.lab.feature.home.ui.viewModel.CharacterViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterListFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(this)[CharacterViewModel::class.java]
    }
    private val characterAdapter by lazy {
        CharacterListAdapter(
            onClick = { character ->
                onCreateCharacterDetail(character)
            }
        )
    }
    private val controller by lazy {
        findNavController()
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
        loadRecycleView()
    }

    private fun loadRecycleView() {
        binding.listCharacteres.adapter = characterAdapter
        binding.listCharacteres.layoutManager = GridLayoutManager(view?.context, 2)
        lifecycleScope.launch {
            viewModel.listData.collect {
                characterAdapter.submitData(it)
            }
        }
    }

    private fun onCreateCharacterDetail(character: Character) {
        val bundle = Bundle()
        bundle.putSerializable("character", character)
        controller.navigate(R.id.action_characterListFragment_to_characterDetail, bundle)
    }
}