package com.clinic.billingclinic.di

import com.clinic.billingclinic.ui.faq.FaqActivity
import com.clinic.billingclinic.ui.home.HomePageActivity
import com.clinic.billingclinic.ui.profile.AddNewProfileActivity
import com.clinic.billingclinic.ui.profile.ProfileListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule{

    @ContributesAndroidInjector(modules = [FragmentHomeModule::class])
    abstract fun contributeHomePageActivity() : HomePageActivity

    @ContributesAndroidInjector
    abstract fun contributeProfileListActivity() : ProfileListActivity

    @ContributesAndroidInjector
    abstract fun contributeAddNewProfileActivity() : AddNewProfileActivity

    @ContributesAndroidInjector
    abstract fun contributeFaqActivity() : FaqActivity
}