package com.filipedrmorgado.lightningmoney.navigation

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

/**
 * Manages navigation between fragments.
 *
 * @property activity The [Activity] used to obtain the [FragmentManager].
 */
class NavigationManager(private val activity: Activity) {

    fun navigateTo(event: NavigationEvent) {
        val fragmentManager = (activity as AppCompatActivity).supportFragmentManager

        when (event) {
            is OpenScreen -> openScreen(fragmentManager, event)
            is CloseScreen -> closeScreen(fragmentManager, event)
        }
    }

    private fun openScreen(fragmentManager: FragmentManager, event: OpenScreen) {
        val transaction = fragmentManager.beginTransaction()

        when (event.openBehaviour) {
            OpenBehaviour.NONE -> Unit // Do nothing special
            OpenBehaviour.ADD -> transaction.addToBackStack(null)
            OpenBehaviour.REPLACE_CURRENT -> {
                if (fragmentManager.backStackEntryCount > 0) {
                    fragmentManager.popBackStack()
                }
            }
        }

        // Instantiate the fragment using the FragmentFactory (newInstance is deprecated)
        val fragment = fragmentManager.fragmentFactory.instantiate(activity.classLoader, event.screenClass.name)
        fragment.arguments = event.bundle

        transaction.replace(event.containerViewId, fragment)
        if (event.addToBackStack) {
            transaction.addToBackStack(event.screenClass.name)
        }

        transaction.commit()
    }


    private fun closeScreen(fragmentManager: FragmentManager, event: CloseScreen) {
        val transaction = fragmentManager.beginTransaction()

        when (event.closeBehaviour) {
            CloseBehaviour.NONE -> Unit // Do nothing special
            CloseBehaviour.SHOW_PREVIOUS -> fragmentManager.popBackStackImmediate()
        }

        // Instantiate the fragment using the FragmentFactory (newInstance is deprecated)
        val fragment = fragmentManager.fragmentFactory.instantiate(activity.classLoader, event.screenClass.name)
        fragment.arguments = event.bundle

        transaction.remove(fragment)
        transaction.commit()
    }
}
