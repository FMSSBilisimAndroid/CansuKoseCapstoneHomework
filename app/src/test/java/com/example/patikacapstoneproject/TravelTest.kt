package com.example.patikacapstoneproject


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.patikacapstoneproject.dto.Travel
import com.example.patikacapstoneproject.repository.TravelRepository
import junit.framework.Assert
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class TravelTest {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    lateinit var travelRepository : TravelRepository
    var allTravels : List<Travel>? = ArrayList<Travel>()

    @Test
    fun `Given travel data are available when I search for travel then I should receive hotel Royal Palm Beach Resort` () = runTest {
        givenTravelServiceIsInitialized()
        whenTravelDataAreReadAndParsed()
        thenTheTravelCollectionShouldContainHotelRoyalPalmBeachResort()
    }

    private fun givenTravelServiceIsInitialized() {
        travelRepository = TravelRepository()
    }

    private suspend fun whenTravelDataAreReadAndParsed() {
        allTravels = travelRepository.fetchTravels()
    }

    private fun thenTheTravelCollectionShouldContainHotelRoyalPalmBeachResort() {
        Assert.assertNotNull(allTravels)
        Assert.assertTrue(allTravels!!.isNotEmpty())
        var containsHotelRoyalPalmBeachResort = false
        allTravels!!.forEach {
            if (it.category.equals(("hotel")) && it.title.equals("Royal Palm Beach Resort")) {
                containsHotelRoyalPalmBeachResort = true
            }
        }
        Assert.assertTrue(containsHotelRoyalPalmBeachResort)
    }
}