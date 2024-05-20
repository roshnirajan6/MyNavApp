package com.example.navigationapp1



import androidx.car.app.CarAppService
import androidx.car.app.Session
import androidx.car.app.validation.HostValidator

class MainService:CarAppService() {
    override fun createHostValidator(): HostValidator {//retunr type is HOstVlidator
        return HostValidator.ALLOW_ALL_HOSTS_VALIDATOR
    }

    override fun onCreateSession(): Session {
        return MainSession()
    }



}