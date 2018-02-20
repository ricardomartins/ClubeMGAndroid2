package pt.rikmartins.clubemg.clubemgandroid.data.local.model

import android.arch.persistence.room.Entity
import pt.rikmartins.clubemg.clubemgandroid.data.local.BaseDataModel
import pt.rikmartins.clubemg.clubemgandroid.data.local.DataLink

@Entity(tableName = "taxonomies")
class Taxonomy(id: Long, apiId: Long, selfLink: DataLink,
               val name: String,
               val slug: String,
               val description: String)
    : BaseDataModel(id, apiId, selfLink)