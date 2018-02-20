package pt.rikmartins.clubemg.clubemgandroid.data.cmgapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import org.joda.time.DateTime

class ApiEvent {
    @Expose
    @SerializedName("url")
    var apiUrl: String? = null
    @Expose
    var id: Long? = null
    @Expose
    var designation: String? = null
    @Expose
    @SerializedName("time_stamp")
    var timeStamp: Long? = null
    @Expose
    var state: String? = null
    @Expose
    @SerializedName("state_details")
    var stateDetails: String? = null
    @Expose
    var starting: DateTime? = null
    @Expose
    var ending: DateTime? = null
    @Expose
    var text: String? = null
    @Expose
    @SerializedName("posts")
    var postsApiUrl: String? = null
    @Expose
    @SerializedName("categories")
    var categoriesApiUrl: String? = null
    @Expose
    @SerializedName("tags")
    var tagsApiUrl: String? = null
    @Expose
    @SerializedName("submission_required")
    var submissionRequired: Boolean? = null
    @Expose
    @SerializedName("submissions_close_at")
    var submissionsCloseAt: DateTime? = null
    @Expose
    @SerializedName("places")
    var placesApiUrl: String? = null
    @Expose
    @SerializedName("starting_place")
    var startingPlace: ApiPlace? = null
}
