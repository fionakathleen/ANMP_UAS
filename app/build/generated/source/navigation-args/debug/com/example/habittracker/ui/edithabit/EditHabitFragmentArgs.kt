package com.example.habittracker.ui.edithabit

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.jvm.JvmStatic

public data class EditHabitFragmentArgs(
  public val habitId: Int,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("habitId", this.habitId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("habitId", this.habitId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): EditHabitFragmentArgs {
      bundle.setClassLoader(EditHabitFragmentArgs::class.java.classLoader)
      val __habitId : Int
      if (bundle.containsKey("habitId")) {
        __habitId = bundle.getInt("habitId")
      } else {
        throw IllegalArgumentException("Required argument \"habitId\" is missing and does not have an android:defaultValue")
      }
      return EditHabitFragmentArgs(__habitId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): EditHabitFragmentArgs {
      val __habitId : Int?
      if (savedStateHandle.contains("habitId")) {
        __habitId = savedStateHandle["habitId"]
        if (__habitId == null) {
          throw IllegalArgumentException("Argument \"habitId\" of type integer does not support null values")
        }
      } else {
        throw IllegalArgumentException("Required argument \"habitId\" is missing and does not have an android:defaultValue")
      }
      return EditHabitFragmentArgs(__habitId)
    }
  }
}
