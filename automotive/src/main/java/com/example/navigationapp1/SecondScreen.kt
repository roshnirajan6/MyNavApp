package com.example.navigationapp1

import Data.Placerepository
import Data.model.toIntent
import android.util.Log
import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.Action
import androidx.car.app.model.ActionStrip
import androidx.car.app.model.CarColor
import androidx.car.app.model.CarIcon
import androidx.car.app.model.MessageTemplate
import androidx.car.app.model.Pane
import androidx.car.app.model.PaneTemplate
import androidx.car.app.model.Row
import androidx.car.app.model.Template
import androidx.core.graphics.drawable.IconCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class SecondScreen(carContext: CarContext, private val placeID : Int) : Screen(carContext) {

    init {
        lifecycle.addObserver(object : LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            fun onStart() {
                Log.i("mytag", "HelloWorldScreen onStart() method")
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            fun onStop() {
                Log.i("mytag", "HelloWorldScreen onStop() method")
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onDestroy() {
                Log.i("mytag", "HelloWorldScreen onDestroy() method")
            }
        })
    }

    private var isFavorite: Boolean = false
    override fun onGetTemplate(): Template {
        val place = Placerepository().getplace(placeID)
            ?: return MessageTemplate.Builder("Place Not Found")
                .setHeaderAction(Action.BACK)
                .build()

        val navigateAction = Action.Builder()
            .setTitle("Navigate")
            .setOnClickListener {
                carContext.startCarApp(place.toIntent(CarContext.ACTION_NAVIGATE))
            }.build()
        val actionStrip = ActionStrip.Builder()
            .addAction(
                Action.Builder()
                    .setIcon(
                        CarIcon.Builder(
                            IconCompat.createWithResource(
                                carContext,
                                R.drawable.baseline_favorite_24

                            )
                        ).build()
                    ).setOnClickListener {
                        //setting  variable value
                        isFavorite = true
                        invalidate()

                    }.build()
            ).build()
        return PaneTemplate.Builder(//we need to use this template to add rows
            Pane.Builder().addAction(navigateAction)
                .addRow(
                    Row.Builder()
                        .setTitle("Coordinates")
                        .addText("Latitude: ${place.latitude},Longitude: ${place.logitide}")
                        .build()
                )
                .addRow(
                    Row.Builder()
                        .setTitle("Address")
                        .addText(place.Address)
                        .build()
                )
                .addRow(
                    Row.Builder()
                        .setTitle("Description")
                        .addText(place.Description)
                        .build()
                ).build()
        ).setTitle(place.location_name)
            .setHeaderAction(Action.BACK)
            .setActionStrip(actionStrip)
            .build()

    }
}
