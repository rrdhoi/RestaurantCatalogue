package com.bikincerdas.restaurantcatalogue.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bikincerdas.core.data.source.Resource
import com.bikincerdas.core.ui.RestaurantAdapter
import com.bikincerdas.restaurantcatalogue.R
import com.bikincerdas.restaurantcatalogue.databinding.FragmentHomeBinding
import com.bikincerdas.restaurantcatalogue.detail.DetailRestaurantActivity
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val restaurantAdapter = RestaurantAdapter()
            restaurantAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailRestaurantActivity::class.java)
                intent.putExtra(DetailRestaurantActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            homeViewModel.restaurant.observe(viewLifecycleOwner, { restaurant ->
                if (restaurant != null) {
                    when (restaurant) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            restaurantAdapter.setData(restaurant.data)
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                        }
                    }
                }
            })

            with(binding.rvRestaurant) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = restaurantAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.rvRestaurant.removeAllViewsInLayout()
        _binding = null
    }
}
