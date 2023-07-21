package com.samant.arcana_toast

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.Typeface
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.samant.arcana_toast.databinding.ArcanaToastBinding


class ArcanaToast {
    companion object {
        const val LONG_DURATION = 5000L // 5 seconds
        const val SHORT_DURATION = 2000L // 2 seconds
        const val GRAVITY_TOP = 560
        const val GRAVITY_CENTER = 20
        const val GRAVITY_BOTTOM = 80

        private lateinit var layoutInflater: LayoutInflater

        private var successToastColor: Int = R.color.dark_success_color_1
        private var errorToastColor: Int = R.color.dark_error_color_1
        private var warningToastColor: Int = R.color.dark_warning_color_1
        private var infoToastColor: Int = R.color.dark_info_color_1
        private var deleteToastColor: Int = R.color.dark_delete_color_1


        fun createToast(
            context: Activity,
            title: String? = null,
            message: String,
            style: ArcanaToastStyle,
            position: Int,
            duration: Long,
            font: Typeface?
        ) {
            layoutInflater = LayoutInflater.from(context)
            // val binding = MotionToastBinding.inflate(layoutInflater)
            val binding = ArcanaToastBinding.inflate(layoutInflater)
            val layout = binding.root
            when (style)
            {
                // Function for Toast Success
                ArcanaToastStyle.SUCCESS -> {
                    val bgColor = ContextCompat.getColor(context, successToastColor)
                    binding.linearLayoutCompat.setBackgroundColor(bgColor)

                    binding.imgTalk.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.success_talk
                        )
                    )
                    binding.imgIcon.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.success_icon
                        )
                    )
                    binding.imgGraphics.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.green_bubbles
                        )
                    )

                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        successToastColor, binding.linearLayoutCompat, context
                    )

                    // Setting up the color for title & Message text
                    binding.tvTitle.setTextColor(Color.WHITE)
                    binding.tvTitle.text = if (title.isNullOrBlank()) ArcanaToastStyle.SUCCESS.getName() else title

                    setDescriptionDetails(font, Color.WHITE, message, binding.tvDescription
                    )

                    // init toast
                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    // Setting Toast Gravity
                    setGravity(position, toast)

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()
                }
                // CTA for Toast Error
                ArcanaToastStyle.ERROR -> {
                    val bgColor = ContextCompat.getColor(context, errorToastColor)
                    binding.linearLayoutCompat.setBackgroundColor(bgColor)

                    binding.imgTalk.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.fail_talk
                        )
                    )
                    binding.imgIcon.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.fail_icon
                        )
                    )
                    binding.imgGraphics.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.red_bubbles
                        )
                    )

                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        errorToastColor, binding.linearLayoutCompat, context
                    )
                    // Setting up the color for title & Message text
                    binding.tvTitle.setTextColor(Color.WHITE)
                    binding.tvTitle.text = if (title.isNullOrBlank()) ArcanaToastStyle.SUCCESS.getName() else title

                    setDescriptionDetails(font, Color.WHITE, message, binding.tvDescription
                    )

                    // init toast
                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    // Setting Toast Gravity
                    setGravity(position, toast)

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()
                }
                // CTA for Toast Warning
                ArcanaToastStyle.WARNING -> {
                    val bgColor = ContextCompat.getColor(context, warningToastColor)
                    binding.linearLayoutCompat.setBackgroundColor(bgColor)

                    binding.imgTalk.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.warning_talk
                        )
                    )
                    binding.imgIcon.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.warning_icon
                        )
                    )
                    binding.imgGraphics.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.yellow_bubbles
                        )
                    )

                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        warningToastColor, binding.linearLayoutCompat, context
                    )

                    // Setting up the color for title & Message text
                    binding.tvTitle.setTextColor(Color.WHITE)
                    binding.tvTitle.text = if (title.isNullOrBlank()) ArcanaToastStyle.SUCCESS.getName() else title

                    setDescriptionDetails(font, Color.WHITE, message, binding.tvDescription
                    )

                    // init toast
                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    // Setting Toast Gravity
                    setGravity(position, toast)

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()
                }
                // CTA for Toast Delete
                ArcanaToastStyle.DELETE -> {
                    val bgColor = ContextCompat.getColor(context, deleteToastColor)
                    binding.linearLayoutCompat.setBackgroundColor(bgColor)

                    binding.imgTalk.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.help_talk
                        )
                    )
                    binding.imgIcon.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.help_icon
                        )
                    )
                    binding.imgGraphics.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.blue_bubbles
                        )
                    )
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        deleteToastColor, binding.linearLayoutCompat, context
                    )

                    // Setting up the color for title & Message text
                    binding.tvTitle.setTextColor(Color.WHITE)
                    binding.tvTitle.text = if (title.isNullOrBlank()) ArcanaToastStyle.SUCCESS.getName() else title

                    setDescriptionDetails(font, Color.WHITE, message, binding.tvDescription
                    )

                    // init toast
                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    // Setting Toast Gravity
                    setGravity(position, toast)

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()

                }
                // CTA for Toast No Internet
                ArcanaToastStyle.NO_INTERNET -> {
                    val bgColor = ContextCompat.getColor(context, deleteToastColor)
                    binding.linearLayoutCompat.setBackgroundColor(bgColor)

                    binding.imgTalk.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.help_talk
                        )
                    )
                    binding.imgIcon.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.help_icon
                        )
                    )
                    binding.imgGraphics.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.blue_bubbles
                        )
                    )

                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        successToastColor, binding.linearLayoutCompat, context
                    )
                    // Setting up the color for title & Message text
                    binding.tvTitle.setTextColor(Color.WHITE)
                    binding.tvTitle.text = if (title.isNullOrBlank()) ArcanaToastStyle.SUCCESS.getName() else title

                    setDescriptionDetails(font, Color.WHITE, message, binding.tvDescription
                    )

                    // init toast
                    val toast = Toast(context.applicationContext)
                    startTimer(duration, toast)

                    // Setting Toast Gravity
                    setGravity(position, toast)

                    // Setting layout to toast
                    toast.view = layout
                    toast.show()

                }
                else -> {
                }
            }
        }
        private fun startTimer(duration: Long, toast: Toast) {
            val timer = object : CountDownTimer(duration, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    // do nothing
                }

                override fun onFinish() {
                    toast.cancel()
                }
            }
            timer.start()
        }

        private fun startPulseAnimation(context: Activity, customToastImage: ImageView) {
            val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
            customToastImage.startAnimation(pulseAnimation)
        }

        private fun setDescriptionDetails(
            font: Typeface?,
            textColor: Int,
            message: String,
            layout: TextView
        ) {
            layout.setTextColor(textColor)
            layout.text = message
            font?.let {
                layout.typeface = font
            }
        }

        private fun setGravity(position: Int, toast: Toast) {
            toast.setGravity(position, 0, 100)
        }

        private fun setBackgroundAndFilter(
            @DrawableRes background: Int,
            @ColorRes colorFilter: Int,
            layout: LinearLayout,
            context: Context
        ) {
            val drawable = ContextCompat.getDrawable(context, background)
            drawable?.colorFilter = PorterDuffColorFilter(
                ContextCompat.getColor(context, colorFilter),
                PorterDuff.Mode.MULTIPLY
            )
            layout.background = drawable
        }
    }
}

