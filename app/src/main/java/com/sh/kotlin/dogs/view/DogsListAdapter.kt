package com.sh.kotlin.dogs.view
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.sh.kotlin.dogs.R
import com.sh.kotlin.dogs.databinding.ItemDogBinding
import com.sh.kotlin.dogs.model.DogBreed
import com.sh.kotlin.dogs.model.util.getProgressDrawable
import com.sh.kotlin.dogs.model.util.loadImage
import kotlinx.android.synthetic.main.item_dog.view.*

class DogsListAdapter(val dogsList: ArrayList<DogBreed>): RecyclerView.Adapter<DogsListAdapter.DogViewHolder>(), DogClickListener {

    class DogViewHolder(var view: ItemDogBinding): RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
       val inflater = LayoutInflater.from(parent.context)
//        val view = inflater.inflate(R.layout.item_dog, parent, false)
        val view = DataBindingUtil.inflate<ItemDogBinding>(inflater, R.layout.item_dog, parent, false)
        return DogViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.view.listener = this
        holder.view.dog = dogsList[position]

    }

    override fun onDogClicked(v: View) {
        val action = ListFragmentDirections.actionDetailFragment()
        action.dogUuid = v.dogId.text.toString().toInt()
        Navigation.findNavController(v).navigate(action)

    }

    override fun getItemCount() = dogsList.size

    fun updateDogList(newDogsList: List<DogBreed>) {
        dogsList.clear()
        dogsList.addAll(newDogsList)
        notifyDataSetChanged()
    }

}