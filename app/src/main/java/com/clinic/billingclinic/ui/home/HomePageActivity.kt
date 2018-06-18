package com.clinic.billingclinic.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.MenuItem
import com.clinic.billingclinic.R
import kotlinx.android.synthetic.main.activity_home_page.*
import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView
import android.util.Log
import dagger.android.support.DaggerAppCompatActivity


class HomePageActivity : DaggerAppCompatActivity() {

    private var selectedItemId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        bottomNavigationDashboardId.setOnNavigationItemSelectedListener { item: MenuItem ->
            addFragmentBasedOnId(item.itemId)
            true
        }
        val fragment = HomeFragment.Companion.newInstance()
        addFragment(fragment)

        disableShiftMode(bottomNavigationDashboardId)

    }


    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentDashboardContentId, fragment, fragment.javaClass.simpleName)
                .commit()
    }


    private fun addFragmentBasedOnId(itemId: Int) {
        selectedItemId = itemId
        when (itemId) {
            R.id.item_home_fragment -> {
                addFragment(HomeFragment.Companion.newInstance())
            }
            R.id.item_appointments_fragment -> {
                addFragment(AppointmentsFragment.Companion.newInstance())
            }
            R.id.item_locations_fragment -> {
                addFragment(LocationsFragment.Companion.newInstance())
            }
            R.id.item_settings_fragment -> {
                addFragment(SettingsFragment.Companion.newInstance())
            }

            else -> {
                addFragment(HomeFragment.Companion.newInstance())
            }
        }
    }


    @SuppressLint("RestrictedApi")
    private fun disableShiftMode(view: BottomNavigationView) {
        val menuView = view.getChildAt(0) as BottomNavigationMenuView
        try {
            val shiftingMode = menuView.javaClass.getDeclaredField("mShiftingMode")
            shiftingMode.isAccessible = true
            shiftingMode.setBoolean(menuView, false)
            shiftingMode.isAccessible = false
            for (i in 0 until menuView.childCount) {
                val item = menuView.getChildAt(i) as BottomNavigationItemView

                item.setShiftingMode(false)
                // set once again checked value, so view will be updated

                item.setChecked(item.itemData.isChecked)
            }
        } catch (e: NoSuchFieldException) {
            Log.e("BNVHelper", "Unable to get shift mode field", e)
        } catch (e: IllegalAccessException) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e)
        }

    }


}
