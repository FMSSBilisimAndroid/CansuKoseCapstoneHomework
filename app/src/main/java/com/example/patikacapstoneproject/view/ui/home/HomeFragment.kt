package com.example.patikacapstoneproject.view.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.patikacapstoneproject.R
import com.example.patikacapstoneproject.dto.GuideCategory
import com.example.patikacapstoneproject.dto.Travel
import com.example.patikacapstoneproject.view.adapter.ViewPagerAdapter
import com.example.patikacapstoneproject.view.ui.travels.RecyclerViewClickListener
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(), RecyclerViewClickListener {

    val tabsArray = arrayOf(
        "All",
        "Flights",
        "Hotels",
        "Transportations"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager.adapter =ViewPagerAdapter(childFragmentManager, lifecycle)
        TabLayoutMediator(tabLayout_deal, viewPager) { tab, position ->
            tab.text = tabsArray[position]
        }.attach()

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