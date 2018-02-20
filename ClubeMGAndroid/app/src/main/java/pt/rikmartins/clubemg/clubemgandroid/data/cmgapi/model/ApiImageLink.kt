package pt.rikmartins.clubemg.clubemgandroid.data.cmgapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ApiImageLink {
    @Expose
    var title: String? = null
    @Expose
    var size: String? = null
    @Expose
    var width: Long? = null
    @Expose
    var height: Long? = null
    @Expose
    var link: String? = null
    @Expose
    @SerializedName("media_type")
    var mediaType: String? = null
    @Expose
    @SerializedName("mime_type")
    var mimeType: String? = null
    @Expose
    var file: String? = null
}
