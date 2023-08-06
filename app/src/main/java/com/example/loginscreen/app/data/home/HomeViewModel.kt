package com.example.loginscreen.app.data.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loginscreen.navigation.PostOfficeAppRouter
import com.example.loginscreen.navigation.Screen
import com.google.firebase.auth.FirebaseAuth

class HomeViewModel : ViewModel() {
    private val TAG = HomeViewModel::class.java.simpleName


    val isUserLogedIn: MutableLiveData<Boolean> = MutableLiveData()
    fun logout() {
        val firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.signOut()

        val authStateListener = FirebaseAuth.AuthStateListener {
            if (it.currentUser == null) {
                Log.d(TAG, "logout: inside sign outsuccess")
                PostOfficeAppRouter.navigateTo(Screen.LoginScreen)
            } else {
                Log.d(TAG, "logout: Inside sign is not complete")
            }
        }
        firebaseAuth.addAuthStateListener(authStateListener)
    }


    fun checkForActiveSession() {
        if (FirebaseAuth.getInstance().currentUser != null) {
            Log.d(TAG, "checkForActiveSession: is login")
            isUserLogedIn.value = true
        } else {
            Log.d(TAG, "checkForActiveSession: User is not logged in")
            isUserLogedIn.value = false
        }
    }


    val emailId: MutableLiveData<String> = MutableLiveData()
    fun getUserData() {
        FirebaseAuth.getInstance().currentUser?.also {
            it.email?.also { email ->
                emailId.value = email
            }
        }
    }
}