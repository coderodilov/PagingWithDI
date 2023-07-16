package uz.coderodilov.paging3withdi.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.coderodilov.paging3withdi.R
import uz.coderodilov.paging3withdi.databinding.FragmentMainBinding
import uz.coderodilov.paging3withdi.ui.adapters.PassengerRvAdapter

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel:MainViewModel by viewModels()
    private var passengerRvAdapter = PassengerRvAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        binding.rvPaging.adapter = passengerRvAdapter

        viewModel.passengers.observe(viewLifecycleOwner){
           passengerRvAdapter.submitData(lifecycle, it)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}