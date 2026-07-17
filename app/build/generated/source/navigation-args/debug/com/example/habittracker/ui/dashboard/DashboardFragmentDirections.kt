package com.example.habittracker.ui.dashboard

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.habittracker.R
import kotlin.Int

public class DashboardFragmentDirections private constructor() {
  private data class ActionDashboardFragmentToEditHabitFragment(
    public val habitId: Int,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_dashboardFragment_to_editHabitFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("habitId", this.habitId)
        return result
      }
  }

  public companion object {
    public fun actionDashboardFragmentToCreateHabitFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_dashboardFragment_to_createHabitFragment)

    public fun actionDashboardFragmentToEditHabitFragment(habitId: Int): NavDirections =
        ActionDashboardFragmentToEditHabitFragment(habitId)
  }
}
