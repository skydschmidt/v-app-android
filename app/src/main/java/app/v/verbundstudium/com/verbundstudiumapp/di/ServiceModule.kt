package app.v.verbundstudium.com.verbundstudiumapp.di

import app.v.verbundstudium.com.verbundstudiumapp.services.*
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton



@Module
class ServiceModule {

    @Provides
    fun provideAccessHandler(accessHandler: BaseAccessHandler): AccessHandler = accessHandler

    @Provides
    fun provideTokenStore(tokenStore: BaseTokenStore): TokenStore = tokenStore

    @Provides
    @Singleton
    fun provideHttpClient(accessHandler: AccessHandler): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(OkHttpHeaderInterceptor(accessHandler))
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(accessHandler: AccessHandler,
                        okHttpClient: OkHttpClient,
                        gson: Gson): Retrofit {
        return Retrofit.Builder()
                .baseUrl(accessHandler.getBaseUrl())
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }

    @Provides
    @Singleton
    fun provideLoginService(retrofit: Retrofit): LoginService = retrofit.create(LoginService::class.java)



    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit): UserService {
        return retrofit.create(UserService::class.java)
    }

    @Provides
    @Singleton
    fun provideMensaService(retrofit: Retrofit): MensaService {
        return retrofit.create(MensaService::class.java)
    }

    @Provides
    @Singleton
    fun provideCalendarService(retrofit: Retrofit): CalendarService {
        return retrofit.create(CalendarService::class.java)
    }

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        return GsonBuilder()
                .create()
    }
}