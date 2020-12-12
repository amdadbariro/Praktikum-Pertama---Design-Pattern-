package com.amdad.appeverything.data.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.amdad.appeverything.data.local.AuthPref
import com.amdad.appeverything.data.model.ActionState
import com.amdad.appeverything.data.model.AuthUser

class AuthRepository (val Context: Context){
    private val authPref: AuthPref by lazy { AuthPref(Context) }

    val authUser = MutableLiveData<AuthUser>(authPref.authUser)
    val isLogin = MutableLiveData<Boolean>(authPref.isLogin)

    suspend fun login(email: String, password: String) : ActionState<AuthUser>{
        return authPref.login(email, password)
    }

    suspend fun register(user: AuthUser) : ActionState<AuthUser>{
        return authPref.register(user)
    }

    suspend fun logout() : ActionState<Boolean>{
        return authPref.logout()
    }
}