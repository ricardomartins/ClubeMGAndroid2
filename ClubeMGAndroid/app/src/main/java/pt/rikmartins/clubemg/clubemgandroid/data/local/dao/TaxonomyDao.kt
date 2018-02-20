package pt.rikmartins.clubemg.clubemgandroid.data.local.dao

import android.arch.persistence.room.*
import pt.rikmartins.clubemg.clubemgandroid.data.local.model.Taxonomy

@Dao
interface TaxonomyDao {
    @Query(value = "SELECT * FROM taxonomies")
    fun getAll(): List<Taxonomy>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTaxonomy(taxonomies: Taxonomy)

    @Delete
    fun deleteTaxonomy(taxonomy: Taxonomy)

    @Update
    fun updateTaxonomy(taxonomy: Taxonomy)
}