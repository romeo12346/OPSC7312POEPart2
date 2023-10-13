package bird.app.opsc7312poepart2

import com.google.android.gms.maps.model.LatLng

data class Place(
    val locId: String,
    val locName: String,
    val  countryCode: String,
    val subnational1Code: String,
    val lat : Double,
    val lng: Double,
    val latestObsDt : String,
    val numSpeciesAllTime: String
)
