package com.example.habittracker.ui.createhabit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.habittracker.R
import com.example.habittracker.data.local.HabitDatabase
import com.example.habittracker.data.model.Habit
import com.example.habittracker.data.repository.HabitRepository
import com.google.android.material.button.MaterialButton

class CreateHabitFragment : Fragment() {

    private lateinit var edtName: EditText
    private lateinit var edtDescription: EditText
    private lateinit var edtGoal: EditText
    private lateinit var edtUnit: EditText

    private lateinit var spinnerIcon: AutoCompleteTextView

    private lateinit var btnCreate: MaterialButton
    private lateinit var btnBack: ImageView

    private lateinit var viewModel: CreateHabitViewModel

    private val iconItems = arrayOf(
        "Fitness",
        "Water",
        "Sleep",
        "Reading"
    )

    private val iconList = arrayOf(
        R.drawable.ic_walk,
        R.drawable.ic_water,
        R.drawable.ic_sleep,
        R.drawable.ic_book
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_create_habit,
            container,
            false
        )

        // Inisialisasi View
        edtName = view.findViewById(R.id.edtName)
        edtDescription = view.findViewById(R.id.edtDescription)
        edtGoal = view.findViewById(R.id.edtGoal)
        edtUnit = view.findViewById(R.id.edtUnit)

        spinnerIcon = view.findViewById(R.id.spinnerIcon)

        btnCreate = view.findViewById(R.id.btnCreate)
        btnBack = view.findViewById(R.id.btnBack)

        // Spinner Icon
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_dropdown_item_1line,
            iconItems
        )

        spinnerIcon.setAdapter(adapter)

        // Room Database
        val database = HabitDatabase.getDatabase(requireContext())

        val repository = HabitRepository(
            database.habitDao()
        )

        val factory = CreateHabitViewModelFactory(repository)

        viewModel = ViewModelProvider(
            this,
            factory
        )[CreateHabitViewModel::class.java]

        // Tombol Create Habit
        btnCreate.setOnClickListener {

            val name = edtName.text.toString().trim()
            val description = edtDescription.text.toString().trim()
            val goalText = edtGoal.text.toString().trim()
            val unit = edtUnit.text.toString().trim()
            val selectedIconName = spinnerIcon.text.toString()

            if (
                name.isEmpty() ||
                description.isEmpty() ||
                goalText.isEmpty() ||
                unit.isEmpty() ||
                selectedIconName.isEmpty()
            ) {

                Toast.makeText(
                    requireContext(),
                    "Semua field harus diisi",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val selectedIndex = iconItems.indexOf(selectedIconName)

            if (selectedIndex == -1) {

                Toast.makeText(
                    requireContext(),
                    "Pilih icon yang tersedia",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val habit = Habit(

                icon = iconList[selectedIndex],

                name = name,

                description = description,

                goal = goalText.toInt(),

                unit = unit,

                progress = 0

            )

            viewModel.addHabit(habit)

            Toast.makeText(
                requireContext(),
                "Habit berhasil dibuat",
                Toast.LENGTH_SHORT
            ).show()

            findNavController().popBackStack()
        }

        // Tombol Back
        btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        return view
    }
}