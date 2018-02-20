package pt.rikmartins.clubemg.clubemgandroid.data.cmgapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ApiTaxonomy {
    @Expose
    @SerializedName("url")
    var apiUrl: String? = null
    @Expose
    var id: Long = 0
    @Expose
    var name: String? = null
    @Expose
    var slug: String? = null
    @Expose
    var description: String? = null
    @Expose
    @SerializedName("posts")
    var postsApiUrl: String? = null
    @Expose
    @SerializedName("events")
    var eventsApiUrl: String? = null
}