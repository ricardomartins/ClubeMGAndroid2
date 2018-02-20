package pt.rikmartins.clubemg.clubemgandroid.data.cmgapi

import pt.rikmartins.clubemg.clubemgandroid.data.cmgapi.model.ApiTaxonomy
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface TagsApi {
    @GET("tags/{id}")
    fun obter(@Path("id") id: Long): Call<ApiTaxonomy>

    @GET("tags/")
    fun obterVarias(): Call<List<ApiTaxonomy>>

    @GET
    fun obterPorUrl(@Url url: String): Call<ApiTaxonomy>

    @GET
    fun obterVariasPorUrl(@Url url: String): Call<List<ApiTaxonomy>>
}