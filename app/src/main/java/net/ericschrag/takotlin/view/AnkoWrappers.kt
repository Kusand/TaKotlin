package net.ericschrag.takotlin.view

import android.view.ViewManager
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar
import org.jetbrains.anko.custom.ankoView

public inline fun ViewManager.smoothProgressBar() = smoothProgressBar {}
public inline fun ViewManager.smoothProgressBar(init: SmoothProgressBar.() -> Unit) = ankoView({ SmoothProgressBar(it) }, init)
