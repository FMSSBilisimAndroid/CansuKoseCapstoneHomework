package com.example.patikacapstoneproject.view.ui.plan

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.patikacapstoneproject.R
import com.example.patikacapstoneproject.databinding.FragmentPlanBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_plan.*
import java.util.*


class PlanFragment : Fragment() {

    private lateinit var binding : FragmentPlanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_plan,container,false)

        createImage()
        return binding.root

    }

    fun createImage(){

        val preference = requireActivity().getSharedPreferences("com.example.patikacapstoneproject", Context.MODE_PRIVATE)
        val editor = preference.edit()

        var imageUrlList = listOf(
            "https://cdn.impala.travel/properties/ckna7pvko007s0uo53ern6inn.jpg",
            "https://cdn.impala.travel/properties/ckna6389z006c0uo53gyeb9oq.jpg",
            "https://cdn.impala.travel/properties/ckn8rk6b200rc0snnhoi1awxu.jpg",
            "https://cdn.impala.travel/properties/ckn8t77g000vk0snnady063y5.jpg"
        )

        var imageViewList = listOf(
            binding.imageView,
            binding.imageView2,
            binding.imageView3,
            binding.imageView4
        )

        var index = preference.getInt("index", 0)

        if (index != -1) {
            for (i in 0 until index) {
                Picasso.get().load(imageUrlList[i]).into(imageViewList[i])
            }
        }

        binding.creatorButton.setOnClickListener {
            if (index != 4) {
                val newIndex = index++
                editor.putInt("index", newIndex)
                editor.apply()
                Picasso.get().load(imageUrlList[newIndex]).into(imageViewList[newIndex])
            }
        }

        binding.imageView.setOnClickListener{
            findNavController().navigate(R.id.action_plan_to_detailFragment)
        }

    }
}