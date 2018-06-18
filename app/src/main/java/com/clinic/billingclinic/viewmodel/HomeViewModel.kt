package com.clinic.billingclinic.viewmodel

import android.arch.lifecycle.*
import javax.inject.Inject

class HomeViewModel  @Inject constructor(): ViewModel()
{

    private var newsList : MutableLiveData<ArrayList<String>> = MutableLiveData()
    fun getNews()
    {
        newsList.value =getDummyNewsData()
    }

    fun getAllNews(): LiveData<ArrayList<String>> = newsList

    private fun getDummyNewsData() : ArrayList<String>
    {
        return arrayListOf("Android is a mobile operating system developed by Google, based on a modified version of the Linux kernel and other open source software and designed primarily for touchscreen mobile devices such as smartphones and tablets. In addition, Google has further developed Android TV for televisions, Android Auto for cars, and Wear OS for wrist watches, each with a specialized user interface.",
                 "Android is a mobile operating system developed by Google, based on a modified version of the Linux kernel and other open source software and designed primarily for touchscreen mobile devices such as smartphones and tablets. In addition, Google has further developed Android TV for televisions, Android Auto for cars, and Wear OS for wrist watches, each with a specialized user interface.",
                 "Android is a mobile operating system developed by Google, based on a modified version of the Linux kernel and other open source software and designed primarily for touchscreen mobile devices such as smartphones and tablets. In addition, Google has further developed Android TV for televisions, Android Auto for cars, and Wear OS for wrist watches, each with a specialized user interface.")
    }
}

