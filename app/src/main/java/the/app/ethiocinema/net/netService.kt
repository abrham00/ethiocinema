package the.app.ethiocinema.net

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*
import the.app.ethiocinema.data.Cinema
import the.app.ethiocinema.data.Movie
import the.app.ethiocinema.data.Schedule

interface netService {

    //MOVIE Services
    @GET("movies")
    fun getAllMoviesFromNet():Call<List<Movie>>

    @GET("schedule")
    fun getSchedule():Call<List<Schedule>>

    @GET("cinemas")
    fun getCinemas():Call<List<Cinema>>

    companion object {

        private val baseUrl = "http://192.168.43.19:88/controller/"

        fun getInstance(): netService {
            val retrofit: Retrofit =  Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()

            return retrofit.create(netService::class.java)
        }
    }
}