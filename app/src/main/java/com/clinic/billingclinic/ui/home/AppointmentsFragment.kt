package com.clinic.billingclinic.ui.home

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clinic.billingclinic.R
import com.clinic.billingclinic.viewmodel.AppointmentsViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.toolbar_header_profile_list_layout.*
import javax.inject.Inject

class AppointmentsFragment : DaggerFragment()
{

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var appointmentsViewModel: AppointmentsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         return inflater.inflate(R.layout.fragment_appointments, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialiseViewModel()
        initialiseToolbar()
    }
    private fun initialiseViewModel()
    {
        appointmentsViewModel = ViewModelProviders.of(this,viewModelFactory).get(AppointmentsViewModel::class.java)
    }
    private fun initialiseToolbar()
    {
        toolbarTxtViewHeading.text = context?.getText(R.string.appointments)
        toolbarTxtCreateProfile.visibility = View.GONE
    }


    companion object {
        fun newInstance(): AppointmentsFragment {
            return AppointmentsFragment()
        }
    }

}