package fr.o80.everythingisfine.inject

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import fr.o80.everythingisfine.domain.CatchPokemon
import fr.o80.everythingisfine.domain.CatchPokemonImpl

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {
    @Binds
    abstract fun bindCatchPokemon(impl: CatchPokemonImpl): CatchPokemon

    // TODO Add other UseCase in this module
}
