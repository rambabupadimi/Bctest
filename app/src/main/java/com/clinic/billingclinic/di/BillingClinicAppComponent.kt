package com.clinic.billingclinic.di

import com.clinic.billingclinic.BillingClinicApp
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,BillingClinicAppModule::class,ActivityBindingModule::class])
interface BillingClinicAppComponent: AndroidInjector<BillingClinicApp>{
    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<BillingClinicApp>()

}