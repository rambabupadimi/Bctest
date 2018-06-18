package com.clinic.billingclinic

import com.clinic.billingclinic.di.DaggerBillingClinicAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BillingClinicApp : DaggerApplication(){
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerBillingClinicAppComponent.builder().create(this)
    }
}