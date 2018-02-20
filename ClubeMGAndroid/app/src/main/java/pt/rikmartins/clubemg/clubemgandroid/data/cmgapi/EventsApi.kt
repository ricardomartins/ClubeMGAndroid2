package pt.rikmartins.clubemg.clubemgandroid.data.cmgapi

import pt.rikmartins.clubemg.clubemgandroid.data.cmgapi.model.ApiEvent
import pt.rikmartins.clubemg.clubemgandroid.data.cmgapi.model.ApiEventPlace
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface EventsApi {
    @GET("events/{id}")
    fun fetchOne(@Path("id") id: Long): Call<ApiEvent>

    @GET("events/")
    fun fetchMonth(@Query("year") year: Int, @Query("month") month: Int): Call<List<ApiEvent>>

    @GET
    fun urlFetchOne(@Url url: String): Call<ApiEvent>

    @GET
    fun urlFetchMany(@Url url: String): Call<List<ApiEvent>>

    @GET
    fun urlFetchManyPlaces(@Url url: String): Call<List<ApiEventPlace>>
}