package com.clinic.billingclinic.di

import com.clinic.billingclinic.ui.home.AppointmentsFragment
import com.clinic.billingclinic.ui.home.HomeFragment
import com.clinic.billingclinic.ui.home.LocationsFragment
import com.clinic.billingclinic.ui.home.SettingsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentHomeModule{

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributeAppointmentsFragment(): AppointmentsFragment

    @ContributesAndroidInjector
    abstract fun contributeLocationsFragment(): LocationsFragment

    @ContributesAndroidInjector
    abstract fun contributeSettingsFragment(): SettingsFragment
}