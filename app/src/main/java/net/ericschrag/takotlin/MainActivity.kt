package net.ericschrag.takotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import net.ericschrag.takotlin.model.Recipe
import net.ericschrag.takotlin.model.RecipeModel
import net.ericschrag.takotlin.presenter.RecipeViewPresenter
import net.ericschrag.takotlin.view.RecipeView
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {
    // https://github.com/evz/tacofancy-api
    val recipeViewPresenter : RecipeViewPresenter = RecipeViewPresenter()
    val recipeModel : RecipeModel = RecipeModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar.setTitle(R.string.random_taco_screen_label)
        val recipeView = RecipeView()
        recipeView.setContentView(this)
        recipeViewPresenter.attachView(recipeView)
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
                    recipeViewPresenter.onRecipeLoaded(recipeModel.getRandomRecipe())
                    return true
                }
                else -> return super.onOptionsItemSelected(item)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}