package com.example.patikacapstoneproject

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.patikacapstoneproject.dto.Image
import com.example.patikacapstoneproject.dto.Travel
import com.example.patikacapstoneproject.repository.TravelRepository
import com.example.patikacapstoneproject.viewmodel.MainViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import junit.framework.Assert.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.junit.rules.TestRule
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

class TravelUnitTests {
    @get:Rule var rule: TestRule = InstantTaskExecutorRule()

    lateinit var mvm : MainViewModel

    @MockK
    lateinit var mockTravelRepository : TravelRepository

    private val mainThreadSurrogate = newSingleThreadContext("Main Thread")

    @Before
    fun initMocksAndMainThread() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

    @Test
    fun `given a view model with live data when populated with travels then results show hotel` () {
        givenViewModelIsInitializedWithMockData()
        whenTravelServiceFetchCountriesInvoked()
        thenResultsShouldContainHotelRoyalPalmBeachResort()
    }

    private fun givenViewModelIsInitializedWithMockData() {
        val travels = ArrayList<Travel>()
        val images = ArrayList<Image>()
        travels.add(Travel("Royal Palm Beach Resort", "", "hotel","" ,"" ,images,false ,""))

        coEvery { mockTravelRepository.fetchTravels() } returns travels

        mvm = MainViewModel(travelRepository = mockTravelRepository)

    }

    private fun whenTravelServiceFetchCountriesInvoked() {
        mvm.fetchTravels()
    }

    private fun thenResultsShouldContainHotelRoyalPalmBeachResort() {
        var allTravels : List<Travel>? = ArrayList<Travel>()
        val latch = CountDownLatch(1)
        val observer = object : Observer<List<Travel>> {
            override fun onChanged(receivedTravels: List<Travel>?) {
                allTravels = receivedTravels
                latch.countDown()
                mvm.travels.removeObserver(this)
            }
        }
        mvm.travels.observeForever(observer)
        latch.await(10, TimeUnit.SECONDS)
        assertNotNull(allTravels)
        assertTrue(allTravels!!.isNotEmpty())
        var containsHotelRoyalPalmBeachResort = false
        allTravels!!.forEach {
            if (it.category.equals(("hotel")) && it.title.equals("Royal Palm Beach Resort")) {
                containsHotelRoyalPalmBeachResort = true
            }
        }
        assertTrue(containsHotelRoyalPalmBeachResort)
    }
}

