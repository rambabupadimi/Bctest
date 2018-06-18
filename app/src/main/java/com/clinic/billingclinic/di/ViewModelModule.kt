package com.clinic.billingclinic.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.clinic.billingclinic.viewmodel.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Provider


@Module
abstract class ViewModelModule{

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProfilesListViewModel::class)
    abstract fun bindProfilesListViewModel(profilesListViewModel: ProfilesListViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(AddNewProfileViewModel::class)
    abstract fun bindAddNewProfileViewModel(addNewProfileViewModel: AddNewProfileViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AppointmentsViewModel::class)
    abstract fun bindAppointmentsViewModel(appointmentsViewModel: AppointmentsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LocationsViewModel::class)
    abstract fun bindLocationsViewModel(locationsViewModel: LocationsViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(FaqViewModel::class)
    abstract fun bindFaqViewModel(faqViewModel: FaqViewModel):ViewModel


    @Module
    companion object {
        @JvmStatic
        @Provides
        fun providesViewModelFactory(creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>): ViewModelProvider.Factory {
            return ViewModelFactory(creators)
        }
    }

}