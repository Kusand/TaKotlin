package net.ericschrag.takotlin.presenter

import net.ericschrag.takotlin.model.Recipe
import net.ericschrag.takotlin.view.RecipeView

class RecipeViewPresenter {
    var recipeView : RecipeView? = null

    fun attachView(recipeView: RecipeView) {
        this.recipeView = recipeView
    }

    fun onRecipeLoaded(recipe: Recipe) {
        recipeView?.showTitle(recipe.name)
    }
}
