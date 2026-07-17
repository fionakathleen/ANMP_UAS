package com.example.habittracker.ui.edithabit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.habittracker.data.local.HabitDatabase
import com.example.habittracker.data.repository.HabitRepository
import com.example.habittracker.databinding.FragmentEditHabitBinding

class EditHabitFragment : Fragment() {

    private var _binding: FragmentEditHabitBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: EditHabitViewModel

    private val args: EditHabitFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentEditHabitBinding.inflate(
            inflater,
            container,
            false
        )

        val database = HabitDatabase.getDatabase(requireContext())

        val repository = HabitRepository(
            database.habitDao()
        )

        val factory = EditHabitViewModelFactory(repository)

        viewModel = ViewModelProvider(
            this,
            factory
        )[EditHabitViewModel::class.java]

        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.getHabitById(args.habitId)
            .observe(viewLifecycleOwner) { habit ->

                habit?.let {
                    viewModel.setHabit(it)
                }

            }

        binding.btnSave.setOnClickListener {

            viewModel.updateHabit()

            findNavController().popBackStack()

        }

        binding.btnBack.setOnClickListener {

            findNavController().popBackStack()

        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}