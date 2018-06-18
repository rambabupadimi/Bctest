package com.clinic.billingclinic.room

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "ProfileEntity")
data class ProfileEntity(

    @PrimaryKey (autoGenerate = true)
    var id:Int,
    var firstName:String,
    var lastName:String,
    var gender:String,
    var dob:String,
    var phoneNumber:String,
    var email:String,
    var relationShip:String){}