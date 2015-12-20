package net.ericschrag.takotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import com.jakewharton.rxbinding.support.v7.widget.RxToolbar
import net.ericschrag.takotlin.model.RecipeModel
import net.ericschrag.takotlin.presenter.RecipeViewPresenter
import net.ericschrag.takotlin.view.RecipeView
import org.jetbrains.anko.*
import rx.Subscription

class MainActivity : AppCompatActivity() {
    // https://github.com/evz/tacofancy-api
    val recipeViewPresenter : RecipeViewPresenter = RecipeViewPresenter()
    val recipeModel : RecipeModel = RecipeModel()

    var toolbarItemClickSubscription : Subscription? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recipeView = RecipeView()
        recipeView.setContentView(this)
        recipeViewPresenter.attachView(recipeView)

        val toolbar : Toolbar = findViewById(R.id.toolbar) as Toolbar
        toolbar.setTitle(R.string.random_taco_screen_label)
        setSupportActionBar(toolbar)

        toolbarItemClickSubscription = RxToolbar.itemClicks(toolbar).subscribe({
                when (it.itemId) {
                    R.id.refresh_action -> {
                        recipeViewPresenter.onRecipeLoaded(recipeModel.getRandomRecipe())
                    }
                }
            })
    }

    override fun onDestroy() {
        super.onDestroy()
        toolbarItemClickSubscription?.unsubscribe()
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        super.onPrepareOptionsMenu(menu)
        menuInflater.inflate(R.menu.random_menu, menu)
        return true
    }

}