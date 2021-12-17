package kanda.lab.feature.home.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kanda.lab.domain.Character
import kanda.lab.feature.home.ui.databinding.CharacterItemBinding

class CharacterListAdapter: PagingDataAdapter<Character, CharacterListAdapter.CharacterViewHolder>(
    DiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CharacterItemBinding.inflate(inflater,parent,false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    inner class CharacterViewHolder(
        private val binding:CharacterItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character) {
            Glide.with(binding.root).load(character.image)
                .into(binding.characterImage)
            binding.characterName.text = character.name
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character) = oldItem == newItem

        override fun areContentsTheSame(oldItem: Character, newItem: Character) = oldItem.id == newItem.id
    }
}