package com.example.patikacapstoneproject.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.patikacapstoneproject.view.ui.flight.FlightFragment
import com.example.patikacapstoneproject.view.ui.hotel.HotelFragment
import com.example.patikacapstoneproject.view.ui.transportation.TransportationFragment
import com.example.patikacapstoneproject.view.ui.travels.TravelFragment

private const val NUM_TABS = 4

public class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return TravelFragment()
            1 -> return FlightFragment()
            2 -> return HotelFragment()
            3 -> return TransportationFragment()
        }
        return TravelFragment()
    }
}