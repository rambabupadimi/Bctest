package com.clinic.billingclinic.ui.profile

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.clinic.billingclinic.R
import com.clinic.billingclinic.room.ProfileEntity
import com.clinic.billingclinic.viewmodel.AddNewProfileViewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_profile_add_new.*
import kotlinx.android.synthetic.main.toolbar_header_profile_list_layout.*
import javax.inject.Inject

class AddNewProfileActivity : DaggerAppCompatActivity() {

    @Inject
     lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var addnewViewModel: AddNewProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_add_new)

        initialiseToolbar()
        initialiseViewModel()
        saveProfileData()
    }

    private fun saveProfileData()
    {
        btnSaveProfile.setOnClickListener {
            var profileEntity:ProfileEntity = ProfileEntity(0,
                    "Padimi",
                    "Rambabu",
                    "Male",
                    "08-01-1991",
                    "8341682265",
                    "babu.ramu111@gmail.com",
                    "Me")
            addnewViewModel.saveProfile(profileEntity)
            launchProfileListActivity()
        }
    }
    private fun launchProfileListActivity()
    {
        val intent = Intent(this, ProfileListActivity::class.java)
        startActivity(intent)
    }
    private fun initialiseViewModel()
    {
        addnewViewModel = ViewModelProviders.of(this,viewModelFactory).get(AddNewProfileViewModel::class.java)
    }
    private fun initialiseToolbar()
    {

        setSupportActionBar(toolbarProfileList)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolbarTxtViewHeading.text = this.getString(R.string.create_profile)
        toolbarTxtCreateProfile.visibility = View.GONE

    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }


}
