package com.sh.kotlin.dogs.view
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.sh.kotlin.dogs.R
import com.sh.kotlin.dogs.model.DogBreed
import com.sh.kotlin.dogs.model.util.getProgressDrawable
import com.sh.kotlin.dogs.model.util.loadImage
import kotlinx.android.synthetic.main.item_dog.view.*

class DogsListAdapter(val dogsList: ArrayList<DogBreed>): RecyclerView.Adapter<DogsListAdapter.DogViewHolder>() {

    class DogViewHolder(var view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
       val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_dog, parent, false)
        return DogViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val currentDog = dogsList[position]
        holder.view.name.text = currentDog.dogBreed
        holder.view.lifespan.text = currentDog.lifeSpan
        holder.view.imageView.loadImage(currentDog.imageUrl, getProgressDrawable(holder.view.context))
        holder.view.setOnClickListener {
            Navigation.findNavController(it).navigate(ListFragmentDirections.actionDetailFragment())
        }
    }

    override fun getItemCount() = dogsList.size

    fun updateDogList(newDogsList: List<DogBreed>) {
        dogsList.clear()
        dogsList.addAll(newDogsList)
        notifyDataSetChanged()
    }

}