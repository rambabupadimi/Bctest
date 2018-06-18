package com.clinic.billingclinic.ui.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clinic.billingclinic.R
import com.clinic.billingclinic.ui.adapter.ViewPagerAdapter
import com.clinic.billingclinic.viewmodel.HomeViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : DaggerFragment()
{

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewPagerAdapter:ViewPagerAdapter
    private lateinit var list:ArrayList<String>
    private lateinit var homeViewModel:HomeViewModel
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View = inflater.inflate(R.layout.fragment_home, container, false)
        initialiseViewModel()
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialiseViewPager()
        observeHomeViewModel()
    }
    private fun initialiseViewModel()
    {
        homeViewModel = ViewModelProviders.of(this,viewModelFactory).get(HomeViewModel::class.java)
    }

    private fun initialiseViewPager()
    {
        list = arrayListOf()
        viewPagerAdapter = ViewPagerAdapter(context, list)
        viewPagerHome.adapter = viewPagerAdapter
        tabLayoutHome.setSelectedTabIndicatorHeight(0)
        tabLayoutHome.setupWithViewPager(viewPagerHome, true)
    }

    private fun observeHomeViewModel()
    {
        homeViewModel.getNews()
        homeViewModel.getAllNews().observe(this, Observer {
            if(it!=null) {
                viewPagerAdapter.add(it)
            }
        })
    }

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}