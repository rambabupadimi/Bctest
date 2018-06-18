package com.clinic.billingclinic.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clinic.billingclinic.R
import com.clinic.billingclinic.room.ProfileEntity
import com.clinic.billingclinic.ui.model.FaqModel
import kotlinx.android.synthetic.main.item_recycler_faq_list.view.*
import kotlinx.android.synthetic.main.item_recycler_profile_list.view.*

class FaqListAdapter(profileList: ArrayList<FaqModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var profileList: ArrayList<FaqModel> = arrayListOf()
    init {
        this.profileList = profileList

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_faq_list, parent, false)
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

        fun bindItems(profileEntity: FaqModel,position: Int) {
            itemView.txtQuestion.text = profileEntity.question
            itemView.txtAnswer.text = profileEntity.answer
        }
    }

    fun addList(postsListT:List<FaqModel>)
    {
        profileList.clear()
        profileList.addAll(postsListT)
        notifyDataSetChanged()
    }

}