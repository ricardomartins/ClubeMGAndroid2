package pt.rikmartins.clubemg.clubemgandroid.data.local.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import com.google.gson.annotations.SerializedName
import org.joda.time.DateTime
import pt.rikmartins.clubemg.clubemgandroid.data.cmgapi.model.ApiPlace
import pt.rikmartins.clubemg.clubemgandroid.data.local.TaxonomicDataModel
import pt.rikmartins.clubemg.clubemgandroid.data.local.DataLink

@Entity(tableName = "events")
class Event(id: Long?, apiId: Long?, selfLink: DataLink?, taxonomiesLink: DataLink?,
            val designation: String?, @ColumnInfo(name = "time_stamp") val timeStamp: Long?,
            val state: String?, @ColumnInfo(name = "state_details") val stateDetails: String?,
            val starting: DateTime?, val ending: DateTime?, val text: String?,
            @ColumnInfo(name = "submission_required") val submissionRequired: Boolean?,
            @ColumnInfo(name = "submissions_close_at") val submissionsCloseAt: DateTime?,
            @ColumnInfo(name = "starting_place") var startingPlace: DataLink?,
            @ColumnInfo(name = "locations_link") val locationsLink: DataLink?)
    : TaxonomicDataModel(id, apiId, selfLink, taxonomiesLink)
