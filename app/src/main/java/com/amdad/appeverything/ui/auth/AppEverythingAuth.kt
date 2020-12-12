package com.amdad.appeverything.ui.auth

import android.content.ComponentCallbacks
import android.content.Context
import com.amdad.appeverything.data.model.ActionState
import com.amdad.appeverything.data.repository.AuthRepository
import kotlinx.coroutines.*

object AppEverythingAuth {
    fun logout(context: Context, callback: ((ActionState<Boolean>) -> Unit)? = null){
        val repo = AuthRepository(context)
        CoroutineScope(Dispatchers.IO).launch {
            val resp = repo.logout()
            withContext(Dispatchers.Main) {
                if (callback != null) callback.invoke(resp)
            }
        }
    }
}