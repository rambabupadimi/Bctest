package com.clinic.billingclinic.room

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface ProfileDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveProfile(profileEntity: ProfileEntity)

    @Query("SELECT * FROM ProfileEntity")
    fun getProfiles(): LiveData<List<ProfileEntity>>
}
