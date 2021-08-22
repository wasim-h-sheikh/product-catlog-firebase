package com.qstest.presentation.di.core

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.qstest.data.api.APIService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import okhttp3.OkHttpClient

import okhttp3.logging.HttpLoggingInterceptor




@Module
class FirebaseModule {
    @Singleton
    @Provides
    fun provideFirebaseRef(): DatabaseReference {
        return Firebase.database.reference
    }

}