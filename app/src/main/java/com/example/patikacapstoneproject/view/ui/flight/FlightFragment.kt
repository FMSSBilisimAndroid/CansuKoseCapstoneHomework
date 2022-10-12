package com.example.patikacapstoneproject.view.ui.flight

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.patikacapstoneproject.R
import com.example.patikacapstoneproject.dto.GuideCategory
import com.example.patikacapstoneproject.dto.Travel
import com.example.patikacapstoneproject.repository.TravelRepository
import com.example.patikacapstoneproject.view.adapter.TravelsFlightAdapter
import com.example.patikacapstoneproject.view.ui.travels.RecyclerViewClickListener
import com.example.patikacapstoneproject.view.ui.travels.TravelViewFlightModelFactory
import com.example.patikacapstoneproject.viewmodel.MainViewFlightModel
import kotlinx.android.synthetic.main.fragment_flight.*

class FlightFragment : Fragment(), RecyclerViewClickListener {
    private lateinit var factory: TravelViewFlightModelFactory
    private lateinit var viewModel: MainViewFlightModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_flight, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repository = TravelRepository()

        factory = TravelViewFlightModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(MainViewFlightModel::class.java)

        viewModel.fetchCategoryTravels("flight")
        viewModel.travelsFlight.observe(viewLifecycleOwner, Observer { travels ->
            recycler_view_flight.also {
                it.layoutManager = LinearLayoutManager(requireContext(),
                    RecyclerView.HORIZONTAL,false)
                it.setHasFixedSize(true)
                it.adapter = TravelsFlightAdapter(travels, this)
            }
        })
    }

    override fun onRecyclerViewItemClick(view: View, travel: Travel) {
        when(view.id){
            R.id.layout_like ->{
                Toast.makeText(requireContext(), "Like Layout Clicked", Toast.LENGTH_LONG).show()
            }
            R.id.imageView -> {
                Toast.makeText(requireContext(), "Book Button Clicked", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onRecyclerViewGuideCategoryClick(view: View, guideCategory: GuideCategory) {

    }
}
