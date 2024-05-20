package Data
import Data.model.Place
val places= listOf(
    Place(0,"Prestige Falcon City","Prestige Falcon City is a large residential project located on Kanakapura Road. It offers modern apartments with a range of amenities including swimming pools, fitness centers, and landscaped gardens.",12.869,77.578,"Kanakapura Road, Bangalore, Karnataka, India - 560062"
    ),
    Place(1,"Sobha City","Sobha City is a luxurious residential development situated on Thanisandra Main Road. It is known for its spacious apartments, lush greenery, and premium amenities such as a clubhouse, sports facilities, and 24/7 security.",13.04912,77.6575,"Thanisandra Main Road, Bangalore, Karnataka, India - 560077"
    ),
    Place(2,"Brigade Cosmopolis","Brigade Cosmopolis is a contemporary residential complex located in Whitefield. It offers apartments with modern amenities and easy access to IT parks, shopping centers, and schools.",12.9698,77.75,"Whitefield, Bangalore, Karnataka, India - 560066"
    ),
    Place(3,"Salarpuria Sattva Greenage","Salarpuria Sattva Greenage is a well-planned residential community situated on Hosur Road. It offers beautifully crafted apartments surrounded by green spaces and features amenities such as a clubhouse, landscaped gardens, and children's play area.",12.9147,77.6156,"Hosur Road, Bangalore, Karnataka, India - 560068"
    ),
    Place(4,"Puravankara Purva Palm Beach","Puravankara Purva Palm Beach is a beach-themed residential project located on Hennur Road. It offers luxurious apartments with a tropical ambiance and amenities like a private beach, swimming pool, and indoor games facility.",13.0451,77.6603,"Hennur Road, Bangalore, Karnataka, India - 560043")
)

class Placerepository {
    fun getPlaces():List<Place>{
        return places
    }

    fun getplace(placeid:Int):Place?{
        return places.find { it.id==placeid }
    }

}

