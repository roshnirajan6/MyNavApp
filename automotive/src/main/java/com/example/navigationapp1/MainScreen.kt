package com.example.navigationapp1
/*
import Data.model.Place
import Data.model.Placerepository
import Data.model.places
//import Data.model.places
//import android.health.connect.datatypes.Metadata
import android.text.Spannable
import android.text.SpannableString
import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.CarLocation
import androidx.car.app.model.Distance
import androidx.car.app.model.DistanceSpan
import androidx.car.app.model.ItemList
import androidx.car.app.model.PlaceListMapTemplate
import androidx.car.app.model.PlaceMarker
import androidx.car.app.model.Row
import androidx.car.app.model.Template
import androidx.car.app.model.Metadata
//import com.sun.istack.Builder


*//*class MainScreen(carContext: CarContext):Screen(carContext) {
    override fun onGetTemplate(): Template {
        val placerepository=Placerepository()
        val itemListBuilder=ItemList.Builder().setNoItemsMessage("no places Found")
        placerepository.getPlaces().forEach{
            
        }
    }

}*//*
class MainScreen(carContext:CarContext) : Screen(carContext) {

    override fun onGetTemplate(): Template {

        val placesRepo = Placerepository()
        val itemListBuilder = ItemList.Builder().setNoItemsMessage("No Such Places Found")

        placesRepo.getPlaces().forEach{

            itemListBuilder.addItem(
                Row.Builder()
                    .setTitle(it.location_name)
                    .addText(SpannableString(" ").apply{
                        setSpan(
                            DistanceSpan.create(Distance.create(Math.random()*100,Distance.UNIT_KILOMETERS)),0,1,
                            Spannable.SPAN_INCLUSIVE_INCLUSIVE)

                    })
                    .setOnClickListener({
                        screenManager.push(SecondScreen(carContext,it.id))
                    }).setMetadata(
                        Metadata.Builder()
                            .setPlace(
                                Place.Builder(CarLocation.create(it.latitude,it.logitide))
                                    .setMarker(PlaceMarker.Builder().build())
                                    .build())
                            .build()
                    )
                    .build()
            )

        }
        return PlaceListMapTemplate.Builder()
            .setTitle("Places Of Interest")
            .setItemList(itemListBuilder.build())
            .build()

    }
}*/

import Data.Placerepository
import android.text.Spannable
import android.text.SpannableString
import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.CarLocation
import androidx.car.app.model.Distance
import androidx.car.app.model.DistanceSpan
import androidx.car.app.model.ItemList
import androidx.car.app.model.Metadata
import androidx.car.app.model.Place
import androidx.car.app.model.PlaceListMapTemplate
import androidx.car.app.model.PlaceMarker
import androidx.car.app.model.Row
import androidx.car.app.model.Template
//import data.model.PlacesRepo

class MainScreen(carContext:CarContext) : Screen(carContext) {

    override fun onGetTemplate(): Template {

        val placesRepo = Placerepository()
        val itemListBuilder = ItemList.Builder().setNoItemsMessage("No Such Places Found")

        placesRepo.getPlaces().forEach{

            itemListBuilder.addItem(
                Row.Builder()
                    .setTitle(it.location_name)
                    .addText(SpannableString(" ").apply{
                        setSpan(
                            DistanceSpan.create(Distance.create(Math.random()*100,Distance.UNIT_KILOMETERS)),
                            0,1,
                            Spannable.SPAN_INCLUSIVE_INCLUSIVE)

                    })
                    .setOnClickListener {
                        screenManager.push(SecondScreen(carContext, it.id))
                    }.setMetadata(
                        Metadata.Builder()
                            .setPlace(
                                Place.Builder(CarLocation.create(it.latitude,it.logitide))
                                    .setMarker(PlaceMarker.Builder().build())
                                    .build())
                            .build()
                    )
                    .build()
            )

        }
        return PlaceListMapTemplate.Builder()
            .setTitle("Welcome ")
            .setItemList(itemListBuilder.build())
            .build()

    }
}
