package kr.co.uxn.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

// @Module은 의존성 주입을 하기위한 provider가 있는 곳
@InstallIn(SingletonComponent::class)
@Module
class AppModules {

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY // 요청/응답 전체 로그
        }
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor) // 로깅 인터셉터 추가
            .build()
    }

    @Singleton // 한번만 생성되게 하겟단 의미
    @Provides // 주입한다는 의미
    @Named("API_URI") // String이 여러개 있을 수 있으니 네임드를 붙여줘야 함
    fun provideWebAPI(): String = "https://api.github.com" // 이 함수명은 아무런 의미가없다. 어떤 타입인지(String)만 본다.

    // GSON : 구글이 만든 JSON 라이브러리
    // JSON <-> 객체 컨버팅해줌
    @Singleton
    @Provides
    fun provideGson(): Gson =
        GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()

    @Singleton
    @Provides
    fun provideConverterFactory(
        gson: Gson
    ): Converter.Factory = GsonConverterFactory.create(gson) // Gson과 retrofit을 연결시켜주는 컨버터.

    @Singleton
    @Provides
    fun provideRetrofit(
        @Named("API_URI") apiUri: String,
        converterFactory: Converter.Factory,
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(apiUri)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()

    @Singleton
    @Provides
    fun provideGithubService(
        retrofit: Retrofit
    ): GithubService = retrofit.create(GithubService::class.java)

}