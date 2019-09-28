package net.pirsquare.kotlinextension

/**
 * Created by Nut on 4/4/2018.
 */

import android.os.SystemClock
import android.view.View

/**
 * 处理快速在某个控件上双击2次(或多次)会导致onClick被触发2次(或多次)的问题
 * 通过判断2次click事件的时间间隔进行过滤
 *
 *
 * 子类通过实现[.onSingleClick]响应click事件
 */
abstract class OnSingleClickListener : View.OnClickListener {
    /**
     * 上次click的时间
     */
    private var mLastClickTime: Long = 0

    /**
     * click响应函数
     *
     * @param v The view that was clicked.
     */
    abstract fun onSingleClick(v: View)

    override fun onClick(v: View) {
        val currentClickTime = SystemClock.uptimeMillis()
        val elapsedTime = currentClickTime - mLastClickTime
        //有可能2次连击，也有可能3连击，保证mLastClickTime记录的总是上次click的时间
        mLastClickTime = currentClickTime

        if (elapsedTime <= MIN_CLICK_INTERVAL)
            return

        onSingleClick(v)
    }

    companion object {
        /**
         * 最短click事件的时间间隔
         */
        private const val MIN_CLICK_INTERVAL: Long = 600
    }

}