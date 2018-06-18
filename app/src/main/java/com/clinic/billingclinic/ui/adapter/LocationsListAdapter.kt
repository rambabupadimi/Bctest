package com.clinic.billingclinic.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clinic.billingclinic.R
import com.clinic.billingclinic.ui.model.LocationsModel
import kotlinx.android.synthetic.main.item_recycler_locations_list.view.*

class LocationsListAdapter(profileList: ArrayList<LocationsModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var profileList: ArrayList<LocationsModel> = arrayListOf()
    init {
        this.profileList = profileList

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_locations_list, parent, false)
        return ItemViewHolder(v)
    }

    override fun getItemCount(): Int {
        return profileList?.size ?: 0;
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is ItemViewHolder) {
            holder.bindItems(profileList[position],position)
        }
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(profileEntity: LocationsModel, position: Int) {
            itemView.txtParam1.text = profileEntity.param1
            itemView.txtParam2.text = profileEntity.param2
            itemView.txtParam3.text = profileEntity.param3
        }
    }

    fun addList(postsListT:List<LocationsModel>)
    {
        profileList.clear()
        profileList.addAll(postsListT)
        notifyDataSetChanged()
    }

}