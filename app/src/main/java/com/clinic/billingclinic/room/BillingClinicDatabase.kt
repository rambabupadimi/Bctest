package com.clinic.billingclinic.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase


@Database(entities = [ProfileEntity::class], version = 1, exportSchema = false)
abstract class BillingClinicDatabase : RoomDatabase(){

    abstract fun profileDao(): ProfileDao

}