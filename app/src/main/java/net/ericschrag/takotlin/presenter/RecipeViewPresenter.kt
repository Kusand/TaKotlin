package net.ericschrag.takotlin.presenter

import net.ericschrag.takotlin.model.Recipe
import net.ericschrag.takotlin.view.RecipeView

class RecipeViewPresenter {
    var recipeView : RecipeView? = null

    fun attachView(recipeView: RecipeView) {
        this.recipeView = recipeView
    }

    fun onLoadStarted() {
        recipeView?.showLoading(true)
        recipeView?.clear()
    }

    fun onRecipeLoaded(recipe: Recipe) {
        recipeView?.showLoading(false)
        recipeView?.showTitle(recipe.name)
    }
}
