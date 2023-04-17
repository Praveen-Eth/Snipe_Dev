package com.augx_universe.snipedev.Listeners

interface AuthListeners {
    fun onSuccess()
    fun onFailure(onFailErrorMessage: String)
}