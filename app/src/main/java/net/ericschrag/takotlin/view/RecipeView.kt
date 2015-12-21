package net.ericschrag.takotlin.view

import android.app.Activity
import android.view.View
import android.widget.TextView
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar
import net.ericschrag.takotlin.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar

class RecipeView : AnkoComponent<Activity> {
    var loadingIndicator: SmoothProgressBar? = null
    var recipeTitle: TextView? = null

    var indicatorRunning: Boolean = false

    override fun createView(ui: AnkoContext<Activity>): View {
        return with(ui) {
            verticalLayout {
                toolbar {
                    id = R.id.toolbar
                    backgroundResource = R.color.colorPrimary
                    lparams(width = matchParent, height = wrapContent)
                }
                loadingIndicator = smoothProgressBar {
                    lparams(width = matchParent, height = wrapContent)
                    isIndeterminate = true
                    // The below are a workaround for the fact that setting indeterminate to true
                    // auto-starts the progress bar, which is not what is wanted
                    visibility = View.INVISIBLE
                    progressiveStop()
                }

                verticalLayout {
                    padding = dip(16)

                    recipeTitle = textView { setTextAppearance(R.style.recipe_name) }
                }
            }
        }
    }

    fun showLoading(show: Boolean) {
        if (show) {
            loadingIndicator?.visibility = View.VISIBLE
            if (!indicatorRunning) {
                indicatorRunning = true
                loadingIndicator?.progressiveStart()
            }
        } else {
            if (indicatorRunning) {
                loadingIndicator?.progressiveStop()
                indicatorRunning = false
            }
        }
    }

    fun showTitle(title: String) {
        recipeTitle?.setText(title)
    }

    fun clear() {
        recipeTitle?.text = ""
    }
}