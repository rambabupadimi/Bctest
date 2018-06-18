package com.clinic.billingclinic.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clinic.billingclinic.R
import com.clinic.billingclinic.room.ProfileEntity
import kotlinx.android.synthetic.main.item_recycler_profile_list.view.*

class ProfilesListAdapter( profileList: ArrayList<ProfileEntity>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var profileList: ArrayList<ProfileEntity> = arrayListOf()
    init {
        this.profileList = profileList

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_profile_list, parent, false)
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

        fun bindItems(profileEntity: ProfileEntity,position: Int) {
            itemView.txtFirstName.text = profileEntity.firstName
            itemView.txtLastName.text = profileEntity.lastName
        }
    }

    fun addList(postsListT:List<ProfileEntity>)
    {
        profileList.clear()
        profileList.addAll(postsListT)
        notifyDataSetChanged()
    }

}