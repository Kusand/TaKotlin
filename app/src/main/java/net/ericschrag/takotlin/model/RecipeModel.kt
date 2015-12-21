package net.ericschrag.takotlin.model

import rx.Observable

class RecipeModel {
    val service: TacoRecipeApi = TacoRecipeApi.create()

    fun getRandomRecipe(): Observable<Recipe> {
        return service.getRandomRecipe()
    }
}