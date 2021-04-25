package fr.o80.everythingisfine.presentation.activity

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import androidx.core.text.inSpans
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import fr.o80.everythingisfine.R
import fr.o80.everythingisfine.presentation.LinkSpan

@AndroidEntryPoint
class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        findViewById<BottomNavigationView>(R.id.bottom_nav).apply {
            selectedItemId = R.id.about
            setOnNavigationItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.home -> startActivity(HomeActivity.newIntent(context))
                    R.id.search_field -> startActivity(SearchActivity.newIntent(context))
                }
                false
            }
        }

        findViewById<TextView>(R.id.content).apply{
            text = buildAboutContent()
            movementMethod = LinkMovementMethod.getInstance()
        }
    }

    private fun buildAboutContent(): CharSequence = buildSpannedString {
        append("Everything is fine, this application will soon go prod!\n")

        append("\nAuthor:\n")
        bold {
            append("Olivier Perez\n")
            inSpans(LinkSpan(this@AboutActivity, "https://github.com/olivierperez")) {
                append("https://github.com/olivierperez\n")
            }
            inSpans(LinkSpan(this@AboutActivity, "https://www.twitch.tv/GNU_Coding_Cafe")) {
                append("https://www.twitch.tv/GNU_Coding_Cafe\n")
            }
        }

        append("\nWith images from:\n")
        bold {
            inSpans(LinkSpan(this@AboutActivity, "https://www.iconfinder.com/Gui_Lhem")) {
                append("Gui_Lhem\n")
            }
            inSpans(LinkSpan(this@AboutActivity, "https://www.iconfinder.com/Ayub_Irawan")) {
                append("Ayub_Irawan\n")
            }
        }
    }

    override fun onBackPressed() {
        startActivity(HomeActivity.newIntent(this))
    }
}
