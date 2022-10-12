package com.example.patikacapstoneproject.view.ui.travels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.patikacapstoneproject.R
import com.example.patikacapstoneproject.dto.GuideCategory
import com.example.patikacapstoneproject.dto.Travel
import com.example.patikacapstoneproject.repository.TravelRepository
import com.example.patikacapstoneproject.view.adapter.TravelsAdapter
import com.example.patikacapstoneproject.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_travel.*

class TravelFragment : Fragment(), RecyclerViewClickListener {
    private lateinit var factory: TravelViewModelFactory
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_travel, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val repository = TravelRepository()

        factory = TravelViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)

        viewModel.fetchTravels()
        viewModel.travels.observe(viewLifecycleOwner, Observer { travels ->
            recycler_view_alltravels.also {
                it.layoutManager = LinearLayoutManager(requireContext(),
                    RecyclerView.HORIZONTAL,false)
                it.setHasFixedSize(true)
                it.adapter = TravelsAdapter(travels, this)
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
        TODO("Not yet implemented")
    }
}
