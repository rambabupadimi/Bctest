package com.clinic.billingclinic.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.clinic.billingclinic.ui.model.FaqModel
import javax.inject.Inject

class FaqViewModel @Inject constructor() : ViewModel()
{

    private var newsList : MutableLiveData<ArrayList<FaqModel>> = MutableLiveData()
    fun getFaqs()
    {
        newsList.value =getDummyNewsData()
    }

    fun getObserveFaqs(): LiveData<ArrayList<FaqModel>> = newsList

    private fun getDummyNewsData() : ArrayList<FaqModel>
    {
        var faqModelList:ArrayList<FaqModel> = arrayListOf()
        faqModelList.add(FaqModel("First question","First Answer"))
        faqModelList.add(FaqModel("Second question","Second Answer"))
        faqModelList.add(FaqModel("Third question","Third Answer"))
        return faqModelList
    }
}