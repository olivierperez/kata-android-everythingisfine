package fr.o80.everythingisfine.inject

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import fr.o80.everythingisfine.data.InMemoryPokedexRepository
import fr.o80.everythingisfine.data.InMemoryPokemonRepository
import fr.o80.everythingisfine.data.PokedexRepository
import fr.o80.everythingisfine.data.PokemonRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindPokemonsRepository(impl: InMemoryPokemonRepository): PokemonRepository

    @Binds
    abstract fun bindPokedexRepository(impl: InMemoryPokedexRepository): PokedexRepository
}
