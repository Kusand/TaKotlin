package net.ericschrag.takotlin.model

import rx.Observable

class RecipeModel {
    fun getRandomRecipe(): Observable<Recipe> {
        return Observable.create(
                Observable.OnSubscribe {
                    it.onStart()
                    Thread.sleep(1500)
                    it.onNext(Recipe("Recipe ${System.currentTimeMillis()}"))
                    it.onCompleted()
                })

    }
}