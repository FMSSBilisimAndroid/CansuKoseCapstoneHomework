package com.example.patikacapstoneproject.view.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.patikacapstoneproject.R
import com.example.patikacapstoneproject.databinding.FragmentSearchBinding
import com.example.patikacapstoneproject.dto.GuideCategory
import com.example.patikacapstoneproject.dto.Travel
import com.example.patikacapstoneproject.repository.TravelRepository
import com.example.patikacapstoneproject.view.adapter.TravelsNearbyAdapter
import com.example.patikacapstoneproject.view.adapter.TravelsTopdestinationAdapter
import com.example.patikacapstoneproject.viewmodel.MainViewNearbyModel
import com.example.patikacapstoneproject.viewmodel.MainViewTopdestinationModel
import kotlinx.android.synthetic.main.fragment_search.*
import android.text.Editable

import android.text.TextWatcher
import androidx.navigation.fragment.findNavController
import com.example.patikacapstoneproject.view.ui.travels.RecyclerViewClickListener
import com.example.patikacapstoneproject.view.ui.travels.TravelViewNearbyModelFactory
import com.example.patikacapstoneproject.view.ui.travels.TravelViewTopdestinationModelFactory


class SearchFragment : Fragment(), RecyclerViewClickListener {

    private lateinit var factoryTopdestinationTravel: TravelViewTopdestinationModelFactory
    private lateinit var viewModeltopdestinationTravel: MainViewTopdestinationModel
    private lateinit var factoryNearbyTravel: TravelViewNearbyModelFactory
    private lateinit var viewModelnearbyTravel: MainViewNearbyModel
    private lateinit var binding : FragmentSearchBinding


    val searchItem = R.id.editTextSearch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_search,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buildRecyclerView()
        binding.editTextSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if(s.isNullOrEmpty()){
                    buildRecyclerView()
                }
                else{
                    buildRecyclerView(s.toString())
                }

            }
            override fun afterTextChanged(s: Editable) {
            }
        })
    }


    fun buildRecyclerView(country: String){
        val repositoryTravel = TravelRepository()
        factoryTopdestinationTravel = TravelViewTopdestinationModelFactory(repositoryTravel)
        viewModeltopdestinationTravel = ViewModelProvider(this, factoryTopdestinationTravel).get(MainViewTopdestinationModel::class.java)
        viewModeltopdestinationTravel.fetchCategoryTravels("topdestination", country)

        viewModeltopdestinationTravel.travelsTopdestination.observe(viewLifecycleOwner, Observer { travelsTopdestination ->
            recyclerView_topdestinationTravel.also {
                it.layoutManager = LinearLayoutManager(requireContext(),
                    RecyclerView.HORIZONTAL,false)
                it.setHasFixedSize(true)
                it.adapter = TravelsTopdestinationAdapter(travelsTopdestination, this)
            }
        })

        factoryNearbyTravel = TravelViewNearbyModelFactory(repositoryTravel)
        viewModelnearbyTravel = ViewModelProvider(this, factoryNearbyTravel).get(MainViewNearbyModel::class.java)
        viewModelnearbyTravel.fetchCategoryTravels("nearby", country)

        viewModelnearbyTravel.travelsNearby.observe(viewLifecycleOwner, Observer { travelsNearby ->
            recyclerView_nearbyTravel.also {
                it.layoutManager = LinearLayoutManager(requireContext(),
                    RecyclerView.HORIZONTAL,false)
                it.setHasFixedSize(true)
                it.adapter = TravelsNearbyAdapter(travelsNearby, this)
            }
        })
    }

    fun buildRecyclerView(){
        val repositoryTravel = TravelRepository()
        factoryTopdestinationTravel = TravelViewTopdestinationModelFactory(repositoryTravel)
        viewModeltopdestinationTravel = ViewModelProvider(this, factoryTopdestinationTravel).get(MainViewTopdestinationModel::class.java)
        viewModeltopdestinationTravel.fetchCategoryTravels("topdestination")

        viewModeltopdestinationTravel.travelsTopdestination.observe(viewLifecycleOwner, Observer { travelsTopdestination ->
            recyclerView_topdestinationTravel.also {
                it.layoutManager = LinearLayoutManager(requireContext(),
                    RecyclerView.HORIZONTAL,false)
                it.setHasFixedSize(true)
                it.adapter = TravelsTopdestinationAdapter(travelsTopdestination, this)
            }
        })

        factoryNearbyTravel = TravelViewNearbyModelFactory(repositoryTravel)
        viewModelnearbyTravel = ViewModelProvider(this, factoryNearbyTravel).get(MainViewNearbyModel::class.java)
        viewModelnearbyTravel.fetchCategoryTravels("nearby")

        viewModelnearbyTravel.travelsNearby.observe(viewLifecycleOwner, Observer { travelsNearby ->
            recyclerView_nearbyTravel.also {
                it.layoutManager = LinearLayoutManager(requireContext(),
                    RecyclerView.VERTICAL,false)
                it.setHasFixedSize(true)
                it.adapter = TravelsNearbyAdapter(travelsNearby, this)
            }
        })
        return
    }

    override fun onRecyclerViewItemClick(view: View, travel: Travel) {
        when(view.id){
            R.id.layout_like ->{
                Toast.makeText(requireContext(), "Like Layout Clicked", Toast.LENGTH_LONG).show()
            }
            R.id.imageView -> {
                Toast.makeText(requireContext(), "Book Button Clicked", Toast.LENGTH_LONG).show()
            }
            R.id.editTextSearch-> {
                Toast.makeText(requireContext(), "Edit text search Clicked", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onRecyclerViewGuideCategoryClick(view: View, guideCategory: GuideCategory) {

    }


}