package com.example.habittracker.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.habittracker.R
import com.example.habittracker.data.local.HabitDatabase
import com.example.habittracker.data.repository.HabitRepository
import com.example.habittracker.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: DashboardViewModel
    private lateinit var adapter: HabitAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDashboardBinding.inflate(
            inflater,
            container,
            false
        )

        // Room
        val database = HabitDatabase.getDatabase(requireContext())

        // Repository
        val repository = HabitRepository(
            database.habitDao()
        )

        // Factory
        val factory = DashboardViewModelFactory(
            repository
        )

        // ViewModel
        viewModel = ViewModelProvider(
            this,
            factory
        )[DashboardViewModel::class.java]

        // RecyclerView
        adapter = HabitAdapter(
            viewModel,
            findNavController()
        )

        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext())

        binding.recyclerView.adapter = adapter

        // Observe data dari Room
        viewModel.habits.observe(viewLifecycleOwner) { habits ->

            adapter.submitList(habits)

        }

        // FAB
        binding.fabAdd.setOnClickListener {

            findNavController().navigate(
                R.id.action_dashboardFragment_to_createHabitFragment
            )

        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}