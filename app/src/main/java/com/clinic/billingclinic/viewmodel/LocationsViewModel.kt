package com.clinic.billingclinic.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.clinic.billingclinic.ui.model.LocationsModel
import javax.inject.Inject

class LocationsViewModel @Inject constructor() : ViewModel()
{
    private var newsList : MutableLiveData<ArrayList<LocationsModel>> = MutableLiveData()
    fun getLocations()
    {
        newsList.value =getDummyLocationsData()
    }

    fun getObserveLocations(): LiveData<ArrayList<LocationsModel>> = newsList

    private fun getDummyLocationsData() : ArrayList<LocationsModel>
    {
        var faqModelList:ArrayList<LocationsModel> = arrayListOf()
        faqModelList.add(LocationsModel("Param1","Param2","Param3"))
        faqModelList.add(LocationsModel("Param1","Param2","Param3"))
        faqModelList.add(LocationsModel("Param1","Param2","Param3"))
        return faqModelList
    }
}
