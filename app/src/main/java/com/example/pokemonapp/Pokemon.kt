package com.example.pokemonapp

import com.google.gson.annotations.SerializedName

data class Pokemon(@SerializedName("id") val id:Int,
                   @SerializedName("name")var name:String,
                   @SerializedName("num")var num:String,
                   @SerializedName("img")var img:String)

data class PokemonRespuesta (@SerializedName("pokemon")var results: List<Pokemon>){
        operator fun get(position: Int) = results[position]
        fun size() = results.size
}





/*data class Pokemon(var id :Int,
                   var num: String,
                   var name: String,
                   var img: String,
                   var type: List<String>?,
                   var height: String,
                   var weight: String,
                   var candy: String,
                   var candyCount:Int,
                   var egg: String,
                   var spawnChance: String?,
                   var avgSpawns: String,
                   var spawnTime: String,
                   var multipliers: List<Double>,
                   var weaknesses: List<String>,
                   var nextEvolution: List<NextEvolution>? = null)*/

