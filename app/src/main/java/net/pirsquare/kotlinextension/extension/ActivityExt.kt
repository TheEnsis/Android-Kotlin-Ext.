package net.pirsquare.kotlinextension.extension

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import net.pirsquare.kotlinextension.R

fun AppCompatActivity.replaceFragmentStateWithAnimation(fragment: Fragment, targetResId: Int, tag: String, lastTag: String) {
    supportFragmentManager.transact {
        setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.my_pop_enter, R.anim.my_pop_exit)
        hide(supportFragmentManager.findFragmentByTag(lastTag)!!)
        add(targetResId, fragment, tag)
        addToBackStack(null)
    }
}

fun AppCompatActivity.replaceFragmentWithAnimation(fragment: Fragment, targetResId: Int, tag: String) {
    supportFragmentManager.transact {
        setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.my_pop_enter, R.anim.my_pop_exit)
        replace(targetResId, fragment, tag)
        addToBackStack(null)
    }
}

fun AppCompatActivity.replaceFragmentWithoutAnim(fragment: Fragment, targetResId: Int, tag: String) {
    supportFragmentManager.transact {
        setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
        replace(targetResId, fragment, tag)
        addToBackStack(null)
    }
}

fun AppCompatActivity.addFragmentToActivity(fragment: Fragment, targetResId: Int, tag: String) {
    supportFragmentManager.transact {
        add(targetResId, fragment, tag)
    }
}

fun AppCompatActivity.addFragmentToActivityWithAnimation(fragment: Fragment, targetResId: Int, tag: String) {
    supportFragmentManager.transact {
        setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.my_pop_enter, R.anim.my_pop_exit)
        add(targetResId, fragment, tag)
    }
}

fun AppCompatActivity.removeFragment(fragment: Fragment) {
    supportFragmentManager.transact {
        remove(fragment)
    }
}


fun AppCompatActivity.setupActionBar(toolbar: Toolbar, action: ActionBar.() -> Unit) {
    setSupportActionBar(toolbar)
    supportActionBar?.run {
        action()
    }
}

/**
 * Runs a FragmentTransaction, then calls commit().
 */
inline fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
    beginTransaction().apply {
        action()
    }.commit()
}
