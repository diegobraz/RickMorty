package kanda.lab.feature.home.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kanda.lab.domain.Character
import kanda.lab.feature.home.ui.R
import kanda.lab.feature.home.ui.databinding.FragmentCharacterDetailBinding
import kanda.lab.feature.home.ui.databinding.FragmentCharacterListBinding

class CharacterDetail : Fragment() {

    private val binding by lazy { FragmentCharacterDetailBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val character = arguments?.getSerializable("character") as Character
        Glide.with(binding.root).load(character.image)
            .into(binding.characterImage)
        binding.characterStatus.text = character.status
        binding.characterFullName.text = character.name
        binding.characterOriginTxt.text = character.origin.name
        binding.characterSpecieTxt.text = character.species
        when(character.gender){
            "Male" ->{
                binding.imageGenre.setImageResource(R.drawable.ic_male_black_24dp)
            }
            "Female" ->{
                binding.imageGenre.setImageResource(R.drawable.ic_female_black_24dp)
            }
            else ->{
                binding.imageGenre.visibility = View.INVISIBLE
            }
        }
    }
}