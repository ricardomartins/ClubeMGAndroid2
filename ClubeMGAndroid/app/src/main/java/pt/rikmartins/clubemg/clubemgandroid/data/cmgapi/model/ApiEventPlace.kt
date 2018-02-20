package pt.rikmartins.clubemg.clubemgandroid.data.cmgapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.joda.time.DateTime

class ApiEventPlace {
    @Expose
    var designation: String? = null
    @Expose
    @SerializedName("place_designation")
    var placeDesignation: String? = null
    @Expose
    var latitude: Double = 0.toDouble()
    @Expose
    var longitude: Double = 0.toDouble()
    @Expose
    var order: Any? = null
    @Expose
    var datetime: DateTime? = null
}
