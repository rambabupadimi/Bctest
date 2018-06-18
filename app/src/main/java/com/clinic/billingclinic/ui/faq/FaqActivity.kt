package com.clinic.billingclinic.ui.faq

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import android.view.View
import com.clinic.billingclinic.R
import com.clinic.billingclinic.ui.adapter.FaqListAdapter
import com.clinic.billingclinic.ui.model.FaqModel
import com.clinic.billingclinic.viewmodel.FaqViewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_faq.*
import kotlinx.android.synthetic.main.toolbar_header_profile_list_layout.*
import javax.inject.Inject

class FaqActivity : DaggerAppCompatActivity() {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var faqViewModel: FaqViewModel

    private lateinit var faqListAdapter: FaqListAdapter
    private var faqList:ArrayList<FaqModel> = arrayListOf()
    private lateinit var mLinearLayoutManager:LinearLayoutManager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faq)

        initialiseToolbar()
        initialiseViewModel()
        initialiseRecyclerView()
        observeViewModel()

    }

    private fun observeViewModel()
    {
        faqViewModel.getFaqs()
        faqViewModel.getObserveFaqs().observe(this, Observer {
            if(it!=null)
                faqListAdapter.addList(it)
        })
    }

    private fun initialiseRecyclerView()
    {
        faqListAdapter = FaqListAdapter(faqList)
        mLinearLayoutManager = LinearLayoutManager(this)
        mLinearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerViewFaqList.layoutManager = mLinearLayoutManager
        recyclerViewFaqList.adapter = faqListAdapter
    }

    private fun initialiseToolbar()
    {
        setSupportActionBar(toolbarProfileList)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbarTxtViewHeading.text= this.getString(R.string.faq)
        toolbarTxtCreateProfile.visibility = View.GONE

    }

    private fun initialiseViewModel()
    {
        faqViewModel = ViewModelProviders.of(this,viewModelFactory).get(FaqViewModel::class.java)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

}
