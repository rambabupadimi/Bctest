package com.clinic.billingclinic.retrofit

import com.clinic.billingclinic.room.ProfileEntity
import retrofit2.Call
import retrofit2.http.GET

interface ApiService{

    @GET(ApiEndPoint.POSTS)
    fun getPostsList(): Call<List<ProfileEntity>>

}