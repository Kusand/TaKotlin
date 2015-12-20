package net.ericschrag.takotlin.view

import android.app.Activity
import android.view.View
import android.widget.TextView
import net.ericschrag.takotlin.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar

class RecipeView : AnkoComponent<Activity> {
    var recipeTitle: TextView? = null

    override fun createView(ui: AnkoContext<Activity>): View {
        return with(ui) {
            verticalLayout {
                toolbar {
                    id = R.id.toolbar
                    backgroundResource = R.color.colorPrimary
                    lparams(width = matchParent, height = wrapContent)
                }
                verticalLayout {
                    padding = dip(16)

                    recipeTitle = textView { setTextAppearance(R.style.recipe_name) }
                }
            }
        }
    }

    fun showTitle(title : String) {
        recipeTitle?.setText(title)
    }

}