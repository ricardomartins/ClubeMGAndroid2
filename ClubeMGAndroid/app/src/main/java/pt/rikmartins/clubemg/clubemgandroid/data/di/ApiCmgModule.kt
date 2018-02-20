package pt.rikmartins.clubemg.clubemgandroid.data.di

import android.net.Uri
import com.github.salomonbrys.kotson.registerTypeAdapter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonPrimitive
import dagger.Module
import dagger.Provides
import org.joda.time.DateTime
import org.joda.time.LocalDate
import pt.rikmartins.clubemg.clubemgandroid.data.cmgapi.CategoriesApi
import pt.rikmartins.clubemg.clubemgandroid.data.cmgapi.EventsApi
import pt.rikmartins.clubemg.clubemgandroid.data.cmgapi.TagsApi
import pt.rikmartins.clubemg.clubemgandroid.data.cmgapi.PostsApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiCmgModule {
    @Provides
    @Singleton
    @Named("apiHost")
    fun provideHostUrl(): Uri {
        return Uri.parse("http://ricardomartins.pythonanywhere.com/")
    }

    @Provides
    @Singleton
    @Named("v1Api")
    fun provideApiV1Url(@Named("apiHost") host: Uri): Uri {
        return host.buildUpon().appendEncodedPath("/api/v1/").build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
                .registerTypeAdapter<DateTime> {
                    serialize { JsonPrimitive(it.src.toString()) }
                    deserialize { DateTime(it.json.asJsonPrimitive.asString) }
                }
                .registerTypeAdapter<LocalDate> {
                    serialize { JsonPrimitive(it.src.toString()) }
                    deserialize { LocalDate(it.json.asJsonPrimitive.asString) }
                }
                .create()
    }

    @Provides
    @Singleton
    @Named("v1Api")
    fun provideRetrofit(@Named("v1Api") api: Uri, gson: Gson): Retrofit {
        return Retrofit.Builder().baseUrl(api.toString())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun provideEventsApi(@Named("v1Api") retrofit: Retrofit): EventsApi {
        return retrofit.create(EventsApi::class.java)
    }

    @Provides
    @Singleton
    fun providePostsApi(@Named("v1Api") retrofit: Retrofit): PostsApi {
        return retrofit.create(PostsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideTagsApi(@Named("v1Api") retrofit: Retrofit): TagsApi {
        return retrofit.create(TagsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCategoriesApi(@Named("v1Api") retrofit: Retrofit): CategoriesApi {
        return retrofit.create(CategoriesApi::class.java)
    }
}