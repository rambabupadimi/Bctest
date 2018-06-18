package com.clinic.billingclinic.ui.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clinic.billingclinic.R
import com.clinic.billingclinic.ui.adapter.LocationsListAdapter
import com.clinic.billingclinic.ui.model.LocationsModel
import com.clinic.billingclinic.viewmodel.LocationsViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_locations.*
import kotlinx.android.synthetic.main.toolbar_header_profile_list_layout.*
import javax.inject.Inject

class LocationsFragment : DaggerFragment()
{

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var locationsViewModel: LocationsViewModel
    private lateinit var locationsListAdapter: LocationsListAdapter
    private var locationsList:ArrayList<LocationsModel> = arrayListOf()
    private lateinit var mLinearLayoutManager:LinearLayoutManager


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_locations, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialiseViewModel()
        initialiseToolbar()
        initialiseRecyclerView()
        observerViewModel()

    }
    private fun initialiseRecyclerView()
    {
        locationsListAdapter = LocationsListAdapter(locationsList)
        mLinearLayoutManager = LinearLayoutManager(context)
        mLinearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerLocationsList.layoutManager = mLinearLayoutManager
        recyclerLocationsList.adapter = locationsListAdapter

    }

    private fun observerViewModel()
    {
        locationsViewModel.getLocations()
        locationsViewModel.getObserveLocations().observe(this, Observer {
            if(it!=null)
                locationsListAdapter.addList(it)
        })

    }

    private fun initialiseViewModel()
    {
        locationsViewModel = ViewModelProviders.of(this,viewModelFactory).get(LocationsViewModel::class.java)
    }

    private fun initialiseToolbar()
    {
        toolbarTxtViewHeading.text = context?.getText(R.string.locations)
        toolbarTxtCreateProfile.visibility = View.GONE
    }

    companion object {
        fun newInstance(): LocationsFragment {
            return LocationsFragment()
        }
    }
}