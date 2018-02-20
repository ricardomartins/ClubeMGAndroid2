package pt.rikmartins.clubemg.clubemgandroid.data.cmgapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import pt.rikmartins.clubemg.clubemgandroid.data.local.model.ImageLink

class ApiPost {
    @Expose
    @SerializedName("url")
    var apiUrl: String? = null
    @Expose
    var id: Long = 0
    @Expose
    var title: String? = null
    @Expose
    var slug: String? = null
    @Expose
    var sticky: Boolean = false
    @Expose
    @SerializedName("images_links")
    var imagesLinks: List<ImageLink>? = null
    @Expose
    @SerializedName("time_stamp")
    var timeStamp: Long = 0
    @Expose
    var excerpt: String? = null
    @Expose
    var content: String? = null
    @Expose
    @SerializedName("categories")
    var categoriesApiUrl: String? = null
    @Expose
    @SerializedName("tags")
    var tagsApiUrl: String? = null
    @Expose
    @SerializedName("post_link")
    var postLink: String? = null
    @Expose
    var date: String? = null // TODO: Date conversion
    @Expose
    @SerializedName("modified_date")
    var modifiedDate: String? = null // TODO: Date conversion
    @Expose
    @SerializedName("events")
    var eventsApiUrl: String? = null
}