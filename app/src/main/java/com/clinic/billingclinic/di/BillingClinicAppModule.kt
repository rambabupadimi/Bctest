package com.clinic.billingclinic.di

import android.content.Context
import com.clinic.billingclinic.BillingClinicApp
import com.clinic.billingclinic.repository.BillingClinicRepository
import com.clinic.billingclinic.retrofit.ApiService
import com.clinic.billingclinic.room.BillingClinicDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(includes = [ViewModelModule::class,DatabaseModule::class,NetworkModule::class])
class BillingClinicAppModule{

    @Provides
    @Singleton
    fun provideAppContext(application: BillingClinicApp): Context {
        return application.applicationContext
    }


    @Provides
    @Singleton
    fun provideRepo(apiService: ApiService, billingClinicDatabase: BillingClinicDatabase) : BillingClinicRepository{
        return BillingClinicRepository(apiService,billingClinicDatabase)
    }

}