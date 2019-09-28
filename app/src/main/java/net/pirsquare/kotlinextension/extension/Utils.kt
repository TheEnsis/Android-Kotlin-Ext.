package net.pirsquare.kotlinextension.extension

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.pirsquare.kotlinextension.BuildConfig


@SuppressLint("ShowToast")
fun Context.showToast(string: String, duration: Int = Toast.LENGTH_SHORT) {
    var toast: Toast? = null
    try {
        toast!!.view.isShown
        toast.setText(string)

    } catch (e: Exception) {
        toast = Toast.makeText(this, string, duration)
    }
    if (BuildConfig.DEBUG)
        toast!!.show()
}

fun debugFunction(action: () -> Unit) {
    if (BuildConfig.DEBUG) action.invoke()
}

fun delayFunction(delay: Long, unit: () -> Unit) {
    GlobalScope.launch(Dispatchers.Main) {
        kotlinx.coroutines.delay(delay)
        unit()
    }
}