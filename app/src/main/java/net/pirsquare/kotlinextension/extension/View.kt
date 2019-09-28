package net.pirsquare.kotlinextension.extension

import android.view.View
import android.view.ViewTreeObserver
import net.pirsquare.kotlinextension.OnSingleClickListener

inline fun View.setOnSingleClickListener(crossinline onClick: () -> Unit) {
    setOnClickListener(object : OnSingleClickListener() {
        override fun onSingleClick(v: View) {
            onClick()
        }
    })
}

fun View.setVisibleClickListener(onClick: (Boolean) -> Unit) {
    setOnClickListener(object : OnSingleClickListener() {
        private var mVisible: Boolean = false

        override fun onSingleClick(v: View) {
            mVisible = !mVisible
            onClick(mVisible)
        }
    })
}

inline fun View.waitForLayout(crossinline f: () -> Unit) = with(viewTreeObserver) {
    addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            removeOnGlobalLayoutListener(this)
            f()
        }
    })
}