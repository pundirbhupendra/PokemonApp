package com.example.pokemonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gridLayoutManager= GridLayoutManager(this,2)
        pokemon_recycleView.layoutManager=gridLayoutManager

        getPokeMon()

    }

    private fun getPokeMon() {

        val pokemonService = ServiceBuilder.buildService(APIService::class.java)

        val requestCall =pokemonService.getPokemonList()

        requestCall.enqueue(object : Callback<PokemonRespuesta>{
            override fun onFailure(call: Call<PokemonRespuesta>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error Occurred" + t.toString(), Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<PokemonRespuesta>,
                response: Response<PokemonRespuesta>
            ) {

                if (response.isSuccessful){
                    // Your status code is in the range of 200's
                    val pokemonList = response.body()!!

                   pokemon_recycleView?.adapter = PokemonListAdapter(this@MainActivity,pokemonList?.results)

                }else{
                    // Your status code is in the range of 300's, 400's and 500's
                    Toast.makeText(this@MainActivity, "Failed to retrieve items", Toast.LENGTH_LONG).show()
                }

            }
        })
    }
}
