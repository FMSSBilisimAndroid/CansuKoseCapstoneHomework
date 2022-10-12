package com.example.patikacapstoneproject.view.ui.transportation

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
import com.example.patikacapstoneproject.view.adapter.TravelsTransportationAdapter
import com.example.patikacapstoneproject.view.ui.travels.RecyclerViewClickListener
import com.example.patikacapstoneproject.view.ui.travels.TravelViewTransportationModelFactory
import com.example.patikacapstoneproject.viewmodel.MainViewTransportationModel
import kotlinx.android.synthetic.main.fragment_transportation.*

class TransportationFragment : Fragment(), RecyclerViewClickListener {
    private lateinit var factory: TravelViewTransportationModelFactory
    private lateinit var viewModel: MainViewTransportationModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_transportation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val repository = TravelRepository()

        factory = TravelViewTransportationModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(MainViewTransportationModel::class.java)

        viewModel.fetchCategoryTravels("transportation")
        viewModel.travelsTransportation.observe(viewLifecycleOwner, Observer { travels ->
            recycler_view_transportation.also {
                it.layoutManager = LinearLayoutManager(requireContext(),
                    RecyclerView.HORIZONTAL,false)
                it.setHasFixedSize(true)
                it.adapter = TravelsTransportationAdapter(travels, this)
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
