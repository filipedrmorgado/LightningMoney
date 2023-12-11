package com.filipedrmorgado.lightningmoney.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment

/**
 * Base for all navigation event that will exist in this application.
 */
sealed interface NavigationEvent

/**
 * Represents a navigation event to open a new screen.
 *
 * @property screenClass The class of the fragment to be opened.
 * @property containerViewId The ID of the container view where the fragment will be placed.
 * @property addToBackStack Indicates whether the transaction should be added to the back stack.
 * @property openBehaviour The behavior to follow when opening the screen (e.g., adding or replacing).
 * @property bundle Optional data to be passed to the fragment.
 */
class OpenScreen(
    val screenClass: Class<out Fragment>,
    val containerViewId: Int,
    val addToBackStack: Boolean,
    val openBehaviour: OpenBehaviour,
    val bundle: Bundle? = null
) : NavigationEvent

/**
 * Enum representing the behavior to follow when opening a screen.
 */
enum class OpenBehaviour {
    /** No specific behavior. */
    NONE,
    /** Add the fragment to the stack. */
    ADD,
    /** Replace the current fragment with a new one. */
    REPLACE_CURRENT,
}

/**
 * Represents a navigation event to close the current screen.
 *
 * @property screenClass The class of the fragment to be closed.
 * @property containerViewId The ID of the container view where the fragment is located.
 * @property addToBackStack Indicates whether the transaction should be added to the back stack.
 * @property closeBehaviour The behavior to follow when closing the screen (e.g., showing the previous).
 * @property bundle Optional data to be passed to the fragment.
 */
data class CloseScreen(
    val screenClass: Class<out Fragment>,
    val containerViewId: Int,
    val addToBackStack: Boolean,
    val closeBehaviour: CloseBehaviour,
    val bundle: Bundle? = null
) : NavigationEvent

/**
 * Enum representing the behavior to follow when closing a screen.
 */
enum class CloseBehaviour {
    /** No specific behavior. */
    NONE,
    /** Show the previous fragment in the stack. */
    SHOW_PREVIOUS,
}