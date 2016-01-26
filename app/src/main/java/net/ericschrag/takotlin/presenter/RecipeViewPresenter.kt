package net.ericschrag.takotlin.presenter

import net.ericschrag.takotlin.model.Recipe
import net.ericschrag.takotlin.view.RecipeView

fun RecipeView.presentLoadStarted() {
    this.clear()
    this.showLoading(true)
}

fun RecipeView.presentRecipe(recipe: Recipe) {
    showLoading(false)
    showTitle(recipe.name)
    showBlurb(recipe.recipe)
}