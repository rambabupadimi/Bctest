package com.clinic.billingclinic.viewmodel

import android.arch.lifecycle.ViewModel
import com.clinic.billingclinic.repository.BillingClinicRepository
import com.clinic.billingclinic.room.ProfileEntity
import javax.inject.Inject

class AddNewProfileViewModel @Inject constructor(billingClinicRepository: BillingClinicRepository) : ViewModel()
{
    private var billingClinicRepository:BillingClinicRepository = billingClinicRepository

    fun saveProfile(profileEntity: ProfileEntity){
        billingClinicRepository.saveProfileLocalDB(profileEntity)
    }
}