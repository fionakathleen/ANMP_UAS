package com.example.habittracker.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.habittracker.databinding.ItemHabitBinding
import com.example.habittracker.data.model.Habit

class HabitAdapter(
    private val viewModel: DashboardViewModel,
    private val navController: NavController
) : ListAdapter<Habit, HabitAdapter.ViewHolder>(HabitDiffCallback()) {

    inner class ViewHolder(
        val binding: ItemHabitBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val binding = ItemHabitBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        val habit = getItem(position)

        holder.binding.habit = habit

        holder.binding.listener =
            object : HabitClickListener {

                override fun onHabitClick(habit: Habit) {

                    val action =
                        DashboardFragmentDirections
                            .actionDashboardFragmentToEditHabitFragment(
                                habit.id
                            )

                    navController.navigate(action)
                }

                override fun onPlusClick(habit: Habit) {

                    viewModel.incrementProgress(habit)

                }

                override fun onMinusClick(habit: Habit) {

                    viewModel.decrementProgress(habit)

                }

            }

        holder.binding.executePendingBindings()

    }
}

class HabitDiffCallback : DiffUtil.ItemCallback<Habit>() {

    override fun areItemsTheSame(
        oldItem: Habit,
        newItem: Habit
    ): Boolean {

        return oldItem.id == newItem.id

    }

    override fun areContentsTheSame(
        oldItem: Habit,
        newItem: Habit
    ): Boolean {

        return oldItem == newItem

    }

}