package stas.batura.vkapitest.repository.net

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.http.GET


object RetrofitClient {

//    val BASE_URL = "https://howtodoinjava.com/"
    val BASE_URL = "https://www.androidhive.info/"

    private val loggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    private val httpClient = OkHttpClient.Builder()

    /**
     * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
     * full Kotlin compatibility.
     */
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
//        .add(KotlinA)
        .build()

    /**
     * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
     * object.
     */
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addConverterFactory(SimpleXmlConverterFactory.create())
//        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(BASE_URL)
        .build()


    object netApi {

        val retrofitServise : API_COUR by lazy {
            retrofit.create(API_COUR::class.java)
        }

    }

    interface API_COUR {
        @GET("feed")
        fun asyncGetFeed(): Deferred<Int>
    }

    }

//    private val api : API by lazy  { provideRetrofit().create(API::class.java) }


