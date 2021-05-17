package fr.o80.everythingisfine.presentation.fragment

import androidx.recyclerview.widget.DiffUtil
import fr.o80.everythingisfine.domain.model.Pokemon

class PokemonDiff : DiffUtil.ItemCallback<Pokemon>() {

    override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return false
    }
}
