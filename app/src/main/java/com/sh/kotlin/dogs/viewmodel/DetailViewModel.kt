package com.sh.kotlin.dogs.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sh.kotlin.dogs.model.DogBreed

class DetailViewModel: ViewModel() {
    val dog = MutableLiveData<DogBreed>()

    fun fetch() {
        val dog1 = DogBreed("1", "Corgi", "15 years", "breedGroup", "breedFor", "temperament", "imageUrl")
        dog.value = dog1
    }
}