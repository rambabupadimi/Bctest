package com.clinic.billingclinic.ui.home

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clinic.billingclinic.R
import com.clinic.billingclinic.ui.faq.FaqActivity
import com.clinic.billingclinic.ui.profile.ProfileListActivity
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.android.synthetic.main.toolbar_header_layout.*

class SettingsFragment : Fragment(),View.OnClickListener
{

    private var mView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(R.layout.fragment_settings, container, false)
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialiseToolbar()
        txtSettingsProfile.setOnClickListener(this)
        txtSettingsAbout.setOnClickListener(this)
        txtSettingsFaq.setOnClickListener(this)
        txtSettingsLegal.setOnClickListener(this)
    }

    private fun initialiseToolbar()
    {
        txtToolbarHeader.text =context?.getString(R.string.settings)
    }
    companion object {
        fun newInstance(): SettingsFragment {
            return SettingsFragment()
        }
    }
    override fun onClick(v: View?) {
        var intent:Intent?=null
        when(v?.id){
            txtSettingsProfile.id -> intent = Intent(context, ProfileListActivity::class.java)
            txtSettingsAbout.id -> Log.i("tag","about")
            txtSettingsFaq.id ->     intent = Intent(context, FaqActivity::class.java)
            txtSettingsLegal.id -> Log.i("tag","legal")
        }
        startActivity(intent)
    }



}