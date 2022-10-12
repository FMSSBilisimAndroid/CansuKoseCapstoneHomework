package com.example.patikacapstoneproject.view.ui.hotel

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
import com.example.patikacapstoneproject.view.adapter.TravelsHotelAdapter
import com.example.patikacapstoneproject.view.ui.travels.RecyclerViewClickListener
import com.example.patikacapstoneproject.view.ui.travels.TravelViewHotelModelFactory
import com.example.patikacapstoneproject.viewmodel.MainViewHotelModel
import kotlinx.android.synthetic.main.fragment_hotel.*

class HotelFragment : Fragment(), RecyclerViewClickListener {
    private lateinit var factory: TravelViewHotelModelFactory
    private lateinit var viewModel: MainViewHotelModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hotel, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repository = TravelRepository()

        factory = TravelViewHotelModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(MainViewHotelModel::class.java)

        viewModel.fetchCategoryTravels("hotel")
        viewModel.travelsHotel.observe(viewLifecycleOwner, Observer { travels ->
            recycler_view_hotel.also {
                it.layoutManager = LinearLayoutManager(requireContext(),
                    RecyclerView.HORIZONTAL,false)
                it.setHasFixedSize(true)
                it.adapter = TravelsHotelAdapter(travels, this)
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
