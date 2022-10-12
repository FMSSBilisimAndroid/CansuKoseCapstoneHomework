package com.example.patikacapstoneproject.view.ui.guidecategories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.patikacapstoneproject.R
import com.example.patikacapstoneproject.dto.GuideCategory
import com.example.patikacapstoneproject.dto.Travel
import com.example.patikacapstoneproject.repository.GuideCategoryRepository
import com.example.patikacapstoneproject.repository.TravelRepository
import com.example.patikacapstoneproject.view.adapter.GuideCategoriesAdapter
import com.example.patikacapstoneproject.view.adapter.TravelsMightneedAdapter
import com.example.patikacapstoneproject.view.adapter.TravelsToppickAdapter
import com.example.patikacapstoneproject.view.ui.travels.RecyclerViewClickListener
import com.example.patikacapstoneproject.view.ui.travels.TravelViewMightneedModelFactory
import com.example.patikacapstoneproject.view.ui.travels.TravelViewToppickModelFactory
import com.example.patikacapstoneproject.viewmodel.GuideCategoryViewModel
import com.example.patikacapstoneproject.viewmodel.MainViewMightneedModel
import com.example.patikacapstoneproject.viewmodel.MainViewToppickModel
import kotlinx.android.synthetic.main.fragment_guide.*


class GuideFragment : Fragment(), RecyclerViewClickListener {

    private lateinit var factory: GuideCategoryViewModelFactory
    private lateinit var factoryToppickTravel: TravelViewToppickModelFactory
    private lateinit var factoryMightneedTravel: TravelViewMightneedModelFactory
    private lateinit var viewModel: GuideCategoryViewModel
    private lateinit var viewModeltoppickTravel: MainViewToppickModel
    private lateinit var viewModelmightneedTravel: MainViewMightneedModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_guide, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = GuideCategoryRepository()

        factory = GuideCategoryViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(GuideCategoryViewModel::class.java)

        viewModel.fetchGuideCategories()

        viewModel.guideCategories.observe(viewLifecycleOwner, Observer { guideCategories ->
            recycler_view_guideCategories.also {
                it.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL,false)
                it.setHasFixedSize(true)
                it.adapter = GuideCategoriesAdapter(guideCategories, this)
            }
        })

        val repositoryTravel = TravelRepository()

        factoryMightneedTravel = TravelViewMightneedModelFactory(repositoryTravel)
        viewModelmightneedTravel = ViewModelProvider(this, factoryMightneedTravel).get(MainViewMightneedModel::class.java)

        viewModelmightneedTravel.fetchCategoryTravels("mightneed")

        viewModelmightneedTravel.travelsMightneed.observe(viewLifecycleOwner, Observer { travelsMightneed->
            recycler_view_mightneedTravel.also {
                it.layoutManager = LinearLayoutManager(requireContext(),RecyclerView.HORIZONTAL,false)
                it.setHasFixedSize(true)
                it.adapter = TravelsMightneedAdapter(travelsMightneed, this)
            }
        })

        factoryToppickTravel = TravelViewToppickModelFactory(repositoryTravel)
        viewModeltoppickTravel = ViewModelProvider(this, factoryToppickTravel).get(MainViewToppickModel::class.java)
        viewModeltoppickTravel.fetchCategoryTravels("toppick")

        viewModeltoppickTravel.travelsToppick.observe(viewLifecycleOwner, Observer { travelsToppick ->
            recycler_view_toppickTravel.also {
                it.layoutManager = LinearLayoutManager(requireContext(),RecyclerView.HORIZONTAL,false)
                it.setHasFixedSize(true)
                it.adapter = TravelsToppickAdapter(travelsToppick, this)
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
        when(view.id){
            R.id.layout_like ->{
                Toast.makeText(requireContext(), "Like Layout Clicked", Toast.LENGTH_LONG).show()
            }
        }
    }

}