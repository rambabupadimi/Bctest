package com.clinic.billingclinic.di

import android.arch.persistence.room.Room
import android.content.Context
import com.clinic.billingclinic.room.BillingClinicDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule{

    private var INSTANCE: BillingClinicDatabase?=null

    @Provides
    @Singleton
    fun getDatabase(context: Context): BillingClinicDatabase {
        if (INSTANCE == null) {
            synchronized(BillingClinicDatabase::class.java) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context,
                            BillingClinicDatabase::class.java, "billing_clinic_db")
                            .build()

                }
            }
        }
        return INSTANCE!!
    }


}