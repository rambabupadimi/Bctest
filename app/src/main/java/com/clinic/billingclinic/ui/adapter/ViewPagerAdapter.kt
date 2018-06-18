package com.clinic.billingclinic.ui.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.clinic.billingclinic.R

class ViewPagerAdapter(private val context: Context?,list:ArrayList<String>) : PagerAdapter() {
    private var layoutInflater: LayoutInflater? = null
    private var listIs:ArrayList<String> = arrayListOf()
    init {
        this.listIs = list
    }

    override fun getCount(): Int {
        return listIs.size
    }
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater!!.inflate(R.layout.item_viewpager_layout, null)
        val textView:TextView = view.findViewById(R.id.txtViewPagerItem)
        textView.text = listIs[position]
        val vp: ViewPager = container as ViewPager
        vp.addView(view, 0)
        return view

    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp = container as ViewPager
        val view = `object` as View
        vp.removeView(view)

    }

    public fun add(list:ArrayList<String>){
        listIs.clear()
        listIs.addAll(list)
        notifyDataSetChanged()
    }
}