package Data.model

import android.content.Intent
import  androidx.core.net.toUri

data class Place (val id:Int,
                  val location_name:String,
                  val Description:String,
                  val latitude:Double,
                  val logitide:Double,
                val Address: String
                  )


fun Place.toIntent(action: String): Intent {
    return Intent(action).apply {
        //writing the format that google accepts
        data = "geo:$latitude,$logitide".toUri()
    }

}


