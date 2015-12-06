package net.ericschrag.takotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {
// https://github.com/evz/tacofancy-api
    var tacoRecipe : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar.setTitle(R.string.random_taco_screen_label)
        setContentView(verticalLayout {
            tacoRecipe = textView()
            button {
                textResource = R.string.refresh_label
                onClick { tacoRecipe!!.text = "Cook ground beef for " + System.currentTimeMillis() + "ms and place in taco shell" }
            }.lparams {
                width = dip(88)
                gravity = Gravity.CENTER_HORIZONTAL
            }
        })
    }

}