package fr.o80.everythingisfine.presentation.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import fr.o80.everythingisfine.R
import fr.o80.everythingisfine.data.model.Pokemon
import fr.o80.everythingisfine.presentation.fragment.DetailsFragment
import fr.o80.everythingisfine.presentation.fragment.ListFragment

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(), ListFragment.PokemonsListListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_content, ListFragment.newInstance())
            commit()
        }

        findViewById<BottomNavigationView>(R.id.bottom_nav).apply {
            selectedItemId = R.id.home
            setOnNavigationItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.search_field -> startActivity(SearchActivity.newIntent(context))
                    R.id.about -> startActivity(Intent(context, AboutActivity::class.java))
                }
                false
            }
        }
    }

    override fun goToDetails(pokemon: Pokemon) {
        supportFragmentManager.commit {
            replace(R.id.main_content, DetailsFragment.newInstance(pokemon.id))
            addToBackStack(null)
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }
}
