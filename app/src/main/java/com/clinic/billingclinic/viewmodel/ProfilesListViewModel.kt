package com.clinic.billingclinic.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.clinic.billingclinic.repository.BillingClinicRepository
import com.clinic.billingclinic.room.ProfileEntity
import javax.inject.Inject

class ProfilesListViewModel @Inject constructor(billingClinicRepository: BillingClinicRepository): ViewModel()
{
    private var billingClinicRepository:BillingClinicRepository = billingClinicRepository
    fun getProfiles():LiveData<List<ProfileEntity>>{
       return billingClinicRepository.getProfilesFromLocalDB()
    }

}