package com.clinic.billingclinic.ui.splash

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.clinic.billingclinic.R
import com.clinic.billingclinic.ui.home.HomePageActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed( { launchHomeActivity() },1000)
    }

    private fun launchHomeActivity()
    {
        val intent = Intent(this, HomePageActivity::class.java)
        startActivity(intent)
        finish()
    }
}
