package com.example.tipoprueba.interfaces

import com.example.tipoprueba.models.ContactResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("api/?results=20&exc=login,registered,dob,id&noinfo")
    suspend fun getContacts(): Response<ContactResponse>
}