package pt.rikmartins.clubemg.clubemgandroid.data.cmgapi.model

import com.google.gson.annotations.Expose

open class ApiPlace {
    @Expose
    var designation: String? = null
    @Expose
    var latitude: Double = 0.toDouble()
    @Expose
    var longitude: Double = 0.toDouble()
}