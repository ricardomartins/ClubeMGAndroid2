package pt.rikmartins.clubemg.clubemgandroid.data.cmgapi

import pt.rikmartins.clubemg.clubemgandroid.data.cmgapi.model.ApiPost
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface PostsApi {
    @GET("posts/{id}")
    fun fetchOne(@Path("id") id: Long): Call<ApiPost>

    @GET("posts/")
    fun fetchMany(): Call<List<ApiPost>>

    @GET
    fun urlFetchOne(@Url url: String): Call<ApiPost>

    @GET
    fun urlFetchMany(@Url url: String): Call<List<ApiPost>>
}