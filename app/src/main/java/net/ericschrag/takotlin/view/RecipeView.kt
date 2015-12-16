package net.ericschrag.takotlin.view

import android.app.Activity
import android.view.View
import android.widget.TextView
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

class RecipeView : AnkoComponent<Activity> {
    var recipeTitle: TextView? = null

    override fun createView(ui: AnkoContext<Activity>): View {
        return with(ui) {
            verticalLayout {
                recipeTitle = textView()
            }
        }
    }

    fun showTitle(title : String) {
        recipeTitle?.setText(title)
    }

}