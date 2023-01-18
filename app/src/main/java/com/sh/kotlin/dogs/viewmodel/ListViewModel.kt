package com.sh.kotlin.dogs.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sh.kotlin.dogs.model.DogBreed

class ListViewModel: ViewModel() {

    val dogs = MutableLiveData<List<DogBreed>>()
    val dogsLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        val dog1 = DogBreed("1", "Corgi", "15 years", "breedGroup", "breedFor", "temperament", "imageUrl")
        val dog2 = DogBreed("2", "breed2", "15 years", "breedGroup", "breedFor", "temperament", "imageUrl")
        val dog3 = DogBreed("3", "breed3", "15 years", "breedGroup", "breedFor", "temperament", "imageUrl")

        val dogList = arrayListOf<DogBreed>(dog1, dog2, dog3)

        dogs.value = dogList
        dogsLoadError.value = false
        loading.value = false

    }


}