package net.ericschrag.takotlin.model

class RecipeModel {
    fun getRandomRecipe() = Recipe("Recipe ${System.currentTimeMillis()}")
}