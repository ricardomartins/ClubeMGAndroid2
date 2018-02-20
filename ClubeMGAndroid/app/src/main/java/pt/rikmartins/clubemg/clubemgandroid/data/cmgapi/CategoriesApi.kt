package pt.rikmartins.clubemg.clubemgandroid.data.cmgapi

import pt.rikmartins.clubemg.clubemgandroid.data.cmgapi.model.ApiTaxonomy
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface CategoriesApi {
    @GET("categories/{id}")
    fun fetchOne(@Path("id") id: Long): Call<ApiTaxonomy>

    @GET("categories/")
    fun fetchMany(): Call<List<ApiTaxonomy>>

    @GET
    fun urlFetchOne(@Url url: String): Call<ApiTaxonomy>

    @GET
    fun urlFetchMany(@Url url: String): Call<List<ApiTaxonomy>>
}