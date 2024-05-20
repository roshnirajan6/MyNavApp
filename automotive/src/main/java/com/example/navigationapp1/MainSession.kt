package com.example.navigationapp1

import android.content.Intent
//import android.se.omapi.Session
import androidx.car.app.Screen
import androidx.car.app.Session


class MainSession : Session(){
    override fun onCreateScreen(intent: Intent): Screen {

        return MainScreen(carContext)
    }


}