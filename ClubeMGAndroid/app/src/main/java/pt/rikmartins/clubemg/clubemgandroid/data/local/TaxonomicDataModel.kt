package pt.rikmartins.clubemg.clubemgandroid.data.local

import android.arch.persistence.room.ColumnInfo

abstract class TaxonomicDataModel(id: Long?, apiId: Long?, selfLink: DataLink?,
                                  @ColumnInfo(name = "taxonomies_links") val taxonomiesLink: DataLink?)
    : BaseDataModel(id, apiId, selfLink) {

    constructor() : this(null, null, null, null)
}