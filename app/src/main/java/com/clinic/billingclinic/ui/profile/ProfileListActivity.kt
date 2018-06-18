package com.clinic.billingclinic.ui.profile

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.clinic.billingclinic.R
import com.clinic.billingclinic.room.ProfileEntity
import com.clinic.billingclinic.ui.adapter.ProfilesListAdapter
import com.clinic.billingclinic.ui.home.HomePageActivity
import com.clinic.billingclinic.viewmodel.ProfilesListViewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_profiles_list.*
import kotlinx.android.synthetic.main.toolbar_header_profile_list_layout.*
import javax.inject.Inject


class ProfileListActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var profileListViewModel:ProfilesListViewModel
    private lateinit var profileListAdapter: ProfilesListAdapter
    private var profilesList:ArrayList<ProfileEntity> = arrayListOf()
    private lateinit var mLinearLayoutManager:LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profiles_list)
        initialiseToolbar()
        initialiseViewModel()
        initialiseRecyclerview()
        observeViewModel()
    }

    private fun initialiseRecyclerview()
    {
        profileListAdapter = ProfilesListAdapter(profilesList)
        mLinearLayoutManager = LinearLayoutManager(this)
        mLinearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerViewProfileList.layoutManager = mLinearLayoutManager
        recyclerViewProfileList.adapter = profileListAdapter

    }

    private fun observeViewModel()
    {
        profileListViewModel.getProfiles().observe(this, Observer {
            if(it!=null)
                profileListAdapter.addList(it)
        })
    }

    private fun initialiseViewModel()
    {
        profileListViewModel = ViewModelProviders.of(this,viewModelFactory).get(ProfilesListViewModel::class.java)
    }
    private fun initialiseToolbar()
    {

        setSupportActionBar(toolbarProfileList)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbarTxtViewHeading.text = this.getString(R.string.profiles)
        toolbarTxtCreateProfile.text = this.getString(R.string.create)
        toolbarTxtCreateProfile.setOnClickListener { launchAddNewProfileActivity() }

    }

    private fun launchAddNewProfileActivity()
    {
        val intent = Intent(this, AddNewProfileActivity::class.java)
        startActivity(intent)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        launchHomePageActivity()
    }

    private fun launchHomePageActivity()
    {
        val intent = Intent(this, HomePageActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            android.R.id.home -> launchHomePageActivity()
        }
        return super.onOptionsItemSelected(item)
    }
}
