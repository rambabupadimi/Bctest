package com.clinic.billingclinic.repository

import android.arch.lifecycle.LiveData
import com.clinic.billingclinic.retrofit.ApiService
import com.clinic.billingclinic.room.BillingClinicDatabase
import com.clinic.billingclinic.room.ProfileEntity

class BillingClinicRepository constructor( apiService: ApiService,
                                           billingClinicDatabase: BillingClinicDatabase)
{
    private var apiService:ApiService = apiService
    private var billingClinicDatabase:BillingClinicDatabase = billingClinicDatabase

    fun saveProfileLocalDB(profileEntity: ProfileEntity)
    {
        val thread = Thread(Runnable { billingClinicDatabase.profileDao().saveProfile(profileEntity) })
        thread.start()
    }

    fun getProfilesFromLocalDB() : LiveData<List<ProfileEntity>>
    {
        return billingClinicDatabase.profileDao().getProfiles()
    }
}