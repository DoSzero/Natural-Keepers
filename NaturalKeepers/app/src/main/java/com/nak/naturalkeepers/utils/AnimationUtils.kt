package com.nak.naturalkeepers.utils

import android.content.Context
import android.util.TypedValue
import android.view.View
import kotlin.math.roundToInt

fun Context.dpToPx(dp: Int): Int {
    return if (dp < 0) dp else (dp * this.resources.displayMetrics.density).roundToInt()
}


fun Context.spToPx(sp: Float): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, this.resources.displayMetrics).toInt()
}


fun animateShow(view: View) {
    view.visibility = View.VISIBLE
    view.animate().alpha(1.0f)
}

fun animateHide(view: View) {
    view.animate().alpha(0.0f)
    view.visibility = View.GONE
}