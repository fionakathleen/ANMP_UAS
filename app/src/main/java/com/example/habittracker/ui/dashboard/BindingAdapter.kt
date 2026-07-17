package com.example.habittracker.ui.dashboard

import android.widget.ProgressBar
import android.widget.TextView
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.habittracker.R
import com.example.habittracker.data.model.Habit
import com.google.android.material.button.MaterialButton

/**
 * Status Habit
 */
@BindingAdapter("habitStatus")
fun bindHabitStatus(textView: TextView, habit: Habit?) {

    habit ?: return

    if (habit.progress >= habit.goal) {

        textView.setText(R.string.completed)

        textView.setTextColor(
            ContextCompat.getColor(
                textView.context,
                R.color.dark_green
            )
        )

        textView.setBackgroundResource(
            R.drawable.status_completed_bg
        )

    } else {

        textView.setText(R.string.in_progress)

        textView.setTextColor(
            ContextCompat.getColor(
                textView.context,
                R.color.dark_purple
            )
        )

        textView.setBackgroundResource(
            R.drawable.status_bg
        )
    }
}

/**
 * Progress Text
 */
@BindingAdapter("progressText")
fun bindProgressText(textView: TextView, habit: Habit?) {

    habit ?: return

    textView.text = textView.context.getString(
        R.string.progress_format,
        habit.progress,
        habit.goal,
        habit.unit
    )
}

/**
 * ProgressBar Max
 */
@BindingAdapter("maxValue")
fun bindMax(progressBar: ProgressBar, max: Int) {

    progressBar.max = max
}

/**
 * ProgressBar Progress
 */
@BindingAdapter("progressValue")
fun bindProgress(progressBar: ProgressBar, progress: Int) {

    progressBar.progress = progress
}

/**
 * Button +
 */
@BindingAdapter("plusEnabled")
fun bindPlusButton(button: MaterialButton, habit: Habit?) {

    habit ?: return

    val enabled = habit.progress < habit.goal

    button.isEnabled = enabled

    if (enabled) {

        button.backgroundTintList =
            ContextCompat.getColorStateList(
                button.context,
                R.color.dark_purple
            )

        button.setTextColor(
            ContextCompat.getColor(
                button.context,
                android.R.color.white
            )
        )

    } else {

        button.backgroundTintList =
            ContextCompat.getColorStateList(
                button.context,
                R.color.light_gray
            )

        button.setTextColor(
            ContextCompat.getColor(
                button.context,
                R.color.dark_gray
            )
        )
    }
}

/**
 * Button -
 */
@BindingAdapter("minusEnabled")
fun bindMinusButton(button: MaterialButton, progress: Int) {

    val enabled = progress > 0

    button.isEnabled = enabled

    button.backgroundTintList =
        ContextCompat.getColorStateList(
            button.context,
            R.color.light_gray
        )

    if (enabled) {

        button.setTextColor(
            ContextCompat.getColor(
                button.context,
                R.color.dark_gray
            )
        )

    } else {

        button.setTextColor(
            ContextCompat.getColor(
                button.context,
                R.color.medium_gray
            )
        )
    }
}

@BindingAdapter("imageRes")
fun setImageResource(imageView: ImageView, resId: Int?) {
    resId?.let {
        imageView.setImageResource(it)
    }
}