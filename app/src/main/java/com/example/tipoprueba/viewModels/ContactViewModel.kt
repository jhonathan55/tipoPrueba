package com.example.tipoprueba.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tipoprueba.models.ContactResponse
import com.example.tipoprueba.retrofit.RetrofitClient
import kotlinx.coroutines.launch

class ContactViewModel: ViewModel(){
    private val _contacts = MutableLiveData<Result<ContactResponse>>()
    val contacts = _contacts

    init {
        fetchContacts()
    }
    private fun fetchContacts() {
        viewModelScope.launch{
            try {
                val response= RetrofitClient.instance.getContacts()
                if(response.isSuccessful){
                    response.body()?.let {
                        _contacts.value = Result.success(it)
                    }?: run{
                        _contacts.value = Result.failure(Exception("Empty response body"))
                    }
                }else{
                    _contacts.value = Result.failure(Exception("Error: ${response.errorBody()?.string()}"))
                }
            }catch (e: Exception){
             _contacts.value = Result.failure(e)
            }
        }
    }
}