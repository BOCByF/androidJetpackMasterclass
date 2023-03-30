package com.sh.kotlin.dogs.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sh.kotlin.dogs.model.DogBreed
import com.sh.kotlin.dogs.model.DogDatabase

class DetailViewModel(application: Application): BaseViewModel(application) {
    val dog = MutableLiveData<DogBreed>()

    fun fetch(uuid: Int) {
        val daoDog = DogDatabase(getApplication()).dogDao().getDog(uuid)
        dog.value = daoDog
    }
}