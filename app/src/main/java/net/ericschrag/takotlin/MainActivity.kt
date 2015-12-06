package net.ericschrag.takotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {
    // https://github.com/evz/tacofancy-api
    var tacoRecipe: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar.setTitle(R.string.random_taco_screen_label)
        setContentView(verticalLayout {
            tacoRecipe = textView()
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.random_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            when (item.itemId) {
                R.id.refresh_action -> {
                    tacoRecipe!!.text = "Cook ground beef for " + System.currentTimeMillis() + "ms and place in taco shell"
                    return true
                }
                else -> return super.onOptionsItemSelected(item)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}