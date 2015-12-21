package net.ericschrag.takotlin.model

import retrofit.GsonConverterFactory
import retrofit.Retrofit
import retrofit.RxJavaCallAdapterFactory
import retrofit.http.GET
import rx.Observable

public interface TacoRecipeApi {
    @GET("/random/?full-taco=true")
    fun getRandomRecipe(): Observable<Recipe>

    companion object {
        fun create(): TacoRecipeApi {
            val restAdapter = Retrofit.Builder()
                        .baseUrl("http://taco-randomizer.herokuapp.com")
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

            return restAdapter.create(TacoRecipeApi::class.java)
        }
    }
}
