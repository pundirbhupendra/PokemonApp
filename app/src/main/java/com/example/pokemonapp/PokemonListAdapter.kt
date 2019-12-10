package com.example.pokemonapp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.pokemon_list.view.*


class PokemonListAdapter(
    var context:Context,
    var pokemonlist: List<Pokemon>
) : RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view:View = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_list,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pokemonlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var list =pokemonlist[position]

        val options = RequestOptions()
            .centerCrop()
           // .signature(path.getFileSignature())
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)


        Glide.with(context)
            .load(list.img)
            .transition(DrawableTransitionOptions.withCrossFade())
            .apply(options)
            .into(holder.imageViewSquare)

        holder.name.text=list.name

    }

    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val imageViewSquare:ImageViewSquare =itemView.pokemon_cover_image
        val name:TextView =itemView.pokemon_name

    }
}