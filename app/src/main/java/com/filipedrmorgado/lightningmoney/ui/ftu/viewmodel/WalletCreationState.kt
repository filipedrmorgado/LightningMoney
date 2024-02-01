package com.filipedrmorgado.lightningmoney.ui.ftu.viewmodel


/**
 * Data class to describe the current state of the wallet creation during FTU.
 */
enum class WalletCreationState {
    NotStarted,
    Loading,
    Success,
    Error
}