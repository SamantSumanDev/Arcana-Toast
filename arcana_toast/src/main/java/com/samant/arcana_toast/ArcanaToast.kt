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
import com.samant.arcana_toast.databinding.FullColorToastBinding


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

        private var successBackgroundToastColor: Int = R.color.success_bg_color
        private var errorBackgroundToastColor: Int = R.color.error_bg_color
        private var warningBackgroundToastColor: Int = R.color.warning_bg_color
        private var infoBackgroundToastColor: Int = R.color.info_bg_color
        private var deleteBackgroundToastColor: Int = R.color.delete_bg_color

        fun resetToastColors() {
            successToastColor = R.color.dark_success_color_1
            errorToastColor = R.color.dark_error_color_1
            warningToastColor = R.color.dark_warning_color_1
            infoToastColor = R.color.dark_info_color_1
            deleteToastColor = R.color.dark_delete_color_1

            successBackgroundToastColor = R.color.success_bg_color
            errorBackgroundToastColor = R.color.error_bg_color
            warningBackgroundToastColor = R.color.warning_bg_color
            infoBackgroundToastColor = R.color.info_bg_color
            deleteBackgroundToastColor = R.color.delete_bg_color
        }

        fun setSuccessColor(color: Int) {
            successToastColor = color
        }

        fun setSuccessBackgroundColor(color: Int) {
            successBackgroundToastColor = color
        }

        fun setErrorColor(color: Int) {
            errorToastColor = color
        }

        fun setErrorBackgroundColor(color: Int) {
            errorBackgroundToastColor = color
        }

        fun setWarningColor(color: Int) {
            warningToastColor = color
        }

        fun setWarningBackgroundColor(color: Int) {
            warningBackgroundToastColor = color
        }

        fun setInfoColor(color: Int) {
            infoToastColor = color
        }

        fun setInfoBackgroundColor(color: Int) {
            infoBackgroundToastColor = color
        }

        fun setDeleteColor(color: Int) {
            deleteToastColor = color
        }

        fun setDeleteBackgroundColor(color: Int) {
            deleteBackgroundToastColor = color
        }

        // all toast CTA
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
            val binding = FullColorToastBinding.inflate(layoutInflater)
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
                // CTA for Toast Info
                ArcanaToastStyle.INFO -> {
                    binding.colorToastImage.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_info_blue
                        )
                    )
                    DrawableCompat.setTint(
                        DrawableCompat.wrap(binding.colorToastImage.drawable),
                        ContextCompat.getColor(context, infoToastColor)
                    )
                    // Pulse Animation for Icon
                    val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                    binding.colorToastImage.startAnimation(pulseAnimation)

                    // round background color
                    setBackgroundAndFilter(
                        R.drawable.toast_round_background,
                        successToastColor, binding.linearLayoutCompat, context
                    )
                    // Setting up the color for title & Message text
                    binding.tvTitle.setTextColor(Color.WHITE)
                    binding.tvTitle.text =
                        if (title.isNullOrBlank()) ArcanaToastStyle.INFO.getName() else title

                    setDescriptionDetails(
                        font,
                        Color.WHITE,
                        message,
                        binding.tvDescription
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


/*


        // all dark toast CTA
            fun darkToast(
                context: Activity,
                title: String? = null,
                message: String,
                style: ArcanaToastStyle,
                position: Int,
                duration: Long,
                font: Typeface?
            ) {
                layoutInflater = LayoutInflater.from(context)
                val binding = FullColorToastBinding.inflate(layoutInflater)
                val layout = binding.root
                when (style) {
                    // Function for Toast Success
                    ArcanaToastStyle.SUCCESS -> {
                        binding.colorToastImage.setImageDrawable(
                            ContextCompat.getDrawable(
                                context,
                                R.drawable.ic_check_green
                            )
                        )
                        DrawableCompat.setTint(
                            DrawableCompat.wrap(binding.colorToastImage.drawable),
                            ContextCompat.getColor(context, successToastColor)
                        )
                        // Pulse Animation for Icon
                        val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                        binding.colorToastImage.startAnimation(pulseAnimation)

                        // round background color
                        setBackgroundAndFilter(
                            R.drawable.toast_round_background,
                            successToastColor, R.id.linearLayoutCompat, context
                        )

                        binding.tvTitle.setTextColor(
                            ContextCompat.getColor(
                                context,
                                successToastColor
                            )
                        )
                        binding.tvTitle.text =
                            if (title.isNullOrBlank()) ArcanaToastStyle.SUCCESS.getName() else title

                        setDescriptionDetails(
                            font,
                            Color.WHITE,
                            message,
                            binding.tvDescription
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
                        binding.colorToastImage.setImageDrawable(
                            ContextCompat.getDrawable(
                                context,
                                R.drawable.ic_error_
                            )
                        )
                        DrawableCompat.setTint(
                            DrawableCompat.wrap(binding.colorToastImage.drawable),
                            ContextCompat.getColor(context, errorToastColor)
                        )
                        // Pulse Animation for Icon
                        val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                        binding.colorToastImage.startAnimation(pulseAnimation)

                        // round background color
                        setBackgroundAndFilter(
                            R.drawable.toast_round_background,
                            R.color.dark_bg_color, layout, context
                        )

                        // Setting up the color for title & Message text
                        binding.tvTitle.setTextColor(
                            ContextCompat.getColor(
                                context,
                                errorToastColor
                            )
                        )
                        binding.tvTitle.text =
                            if (title.isNullOrBlank()) ArcanaToastStyle.ERROR.getName() else title

                        setDescriptionDetails(
                            font,
                            Color.WHITE,
                            message,
                            binding.tvDescription
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
                        binding.colorToastImage.setImageDrawable(
                            ContextCompat.getDrawable(
                                context,
                                R.drawable.ic_warning_yellow
                            )
                        )
                        DrawableCompat.setTint(
                            DrawableCompat.wrap(binding.colorToastImage.drawable),
                            ContextCompat.getColor(context, warningToastColor)
                        )
                        // Pulse Animation for Icon
                        val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                        binding.colorToastImage.startAnimation(pulseAnimation)

                        // round background color
                        setBackgroundAndFilter(
                            R.drawable.toast_round_background,
                            R.color.dark_bg_color, layout, context
                        )

                        // Setting up the color for title & Message text
                        binding.tvTitle.setTextColor(
                            ContextCompat.getColor(
                                context,
                                warningToastColor
                            )
                        )
                        binding.tvTitle.text =
                            if (title.isNullOrBlank()) ArcanaToastStyle.WARNING.getName() else title

                        setDescriptionDetails(
                            font,
                            Color.WHITE,
                            message,
                            binding.tvDescription
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
                    // CTA for Toast Info
                    ArcanaToastStyle.INFO -> {
                        binding.colorToastImage.setImageDrawable(
                            ContextCompat.getDrawable(
                                context,
                                R.drawable.ic_info_blue
                            )
                        )
                        DrawableCompat.setTint(
                            DrawableCompat.wrap(binding.colorToastImage.drawable),
                            ContextCompat.getColor(context, infoToastColor)
                        )
                        // Pulse Animation for Icon
                        val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                        binding.colorToastImage.startAnimation(pulseAnimation)

                        // round background color
                        setBackgroundAndFilter(
                            R.drawable.toast_round_background,
                            R.color.dark_bg_color, layout, context
                        )

                        // Setting up the color for title & Message text
                        binding.tvTitle.setTextColor(
                            ContextCompat.getColor(
                                context,
                                infoToastColor
                            )
                        )
                        binding.tvTitle.text =
                            if (title.isNullOrBlank()) ArcanaToastStyle.INFO.getName() else title

                        setDescriptionDetails(
                            font,
                            Color.WHITE,
                            message,
                            binding.tvDescription
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
                        binding.colorToastImage.setImageDrawable(
                            ContextCompat.getDrawable(
                                context,
                                R.drawable.ic_delete_
                            )
                        )
                        DrawableCompat.setTint(
                            DrawableCompat.wrap(binding.colorToastImage.drawable),
                            ContextCompat.getColor(context, deleteToastColor)
                        )
                        // Pulse Animation for Icon
                        val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                        binding.colorToastImage.startAnimation(pulseAnimation)

                        // round background color
                        setBackgroundAndFilter(
                            R.drawable.toast_round_background,
                            R.color.dark_bg_color, layout, context
                        )

                        // Setting up the color for title & Message text
                        binding.tvTitle.setTextColor(
                            ContextCompat.getColor(
                                context,
                                deleteToastColor
                            )
                        )
                        binding.tvTitle.text =
                            if (title.isNullOrBlank()) ArcanaToastStyle.DELETE.getName() else title

                        setDescriptionDetails(
                            font,
                            Color.WHITE,
                            message,
                            binding.tvDescription
                        )

                        // init toast
                        val toast = Toast(context.applicationContext)

                        //   Setting up the duration
                        startTimer(duration, toast)

                        // Setting Toast Gravity
                        setGravity(position, toast)

                        // Setting layout to toast
                        toast.view = layout
                        toast.show()

                    }
                    // CTA for Toast No Internet
                    ArcanaToastStyle.NO_INTERNET -> {
                        binding.colorToastImage.setImageDrawable(
                            ContextCompat.getDrawable(
                                context,
                                R.drawable.ic_no_internet
                            )
                        )
                        DrawableCompat.setTint(
                            DrawableCompat.wrap(binding.colorToastImage.drawable),
                            ContextCompat.getColor(context, warningToastColor)
                        )
                        // Pulse Animation for Icon
                        val pulseAnimation = AnimationUtils.loadAnimation(context, R.anim.pulse)
                        binding.colorToastImage.startAnimation(pulseAnimation)

                        // round background color
                        setBackgroundAndFilter(
                            R.drawable.toast_round_background,
                            R.color.dark_bg_color, layout, context
                        )

                        // Setting up the color for title & Message text
                        binding.tvTitle.setTextColor(
                            ContextCompat.getColor(
                                context,
                                warningToastColor
                            )
                        )
                        binding.tvTitle.text =
                            if (title.isNullOrBlank()) ArcanaToastStyle.NO_INTERNET.getName() else title

                        setDescriptionDetails(
                            font,
                            Color.WHITE,
                            message,
                            binding.tvDescription
                        )

                        // init toast
                        val toast = Toast(context.applicationContext)

                        //   Setting up the duration
                        startTimer(duration, toast)

                        // Setting Toast Gravity
                        setGravity(position, toast)

                        // Setting layout to toast
                        toast.view = layout
                        toast.show()

                    }
                }
            }

            // all toast CTA
            fun darkColorToast(
                context: Activity,
                title: String? = null,
                message: String,
                style: ArcanaToastStyle,
                position: Int,
                duration: Long,
                font: Typeface?
            ) {
                layoutInflater = LayoutInflater.from(context)
                val binding = ArcanaToastBinding.inflate(layoutInflater)
                val layout = binding.root
                when (style) {
                    // Function for Toast Success
                    ArcanaToastStyle.SUCCESS -> {
                        binding.customToastImage.setImageDrawable(
                            ContextCompat.getDrawable(
                                context,
                                R.drawable.ic_check_green
                            )
                        )
                        DrawableCompat.setTint(
                            DrawableCompat.wrap(binding.customToastImage.drawable),
                            ContextCompat.getColor(context, successToastColor)
                        )
                        // Pulse Animation for Icon
                        startPulseAnimation(context, binding.customToastImage)

                        // Background tint color for side view
                        binding.colorView.backgroundTintList =
                            ContextCompat.getColorStateList(context, successToastColor)

                        // round background color
                        setBackgroundAndFilter(
                            R.drawable.toast_round_background,
                            R.color.dark_bg_color, layout, context
                        )

                        // Setting up the color for title & Message text
                        binding.customToastText.setTextColor(
                            ContextCompat.getColor(
                                context,
                                successToastColor
                            )
                        )
                        binding.customToastText.text =
                            if (title.isNullOrBlank()) ArcanaToastStyle.SUCCESS.getName() else title

                        setDescriptionDetails(
                            font,
                            Color.WHITE,
                            message,
                            binding.customToastDescription
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
                        binding.customToastImage.setImageDrawable(
                            ContextCompat.getDrawable(
                                context,
                                R.drawable.ic_error_
                            )
                        )
                        DrawableCompat.setTint(
                            DrawableCompat.wrap(binding.customToastImage.drawable),
                            ContextCompat.getColor(context, errorToastColor)
                        )
                        startPulseAnimation(context, binding.customToastImage)
                        binding.colorView.backgroundTintList =
                            ContextCompat.getColorStateList(context, errorToastColor)

                        setBackgroundAndFilter(
                            R.drawable.toast_round_background,
                            R.color.dark_bg_color, layout, context
                        )

                        binding.customToastText.setTextColor(
                            ContextCompat.getColor(
                                context,
                                errorToastColor
                            )
                        )
                        binding.customToastText.text =
                            if (title.isNullOrBlank()) ArcanaToastStyle.ERROR.getName() else title

                        setDescriptionDetails(
                            font,
                            Color.WHITE,
                            message,
                            binding.customToastDescription
                        )

                        val toast = Toast(context.applicationContext)
                        startTimer(duration, toast)

                        setGravity(position, toast)
                        toast.view = layout//setting the view of custom toast layout
                        toast.show()
                    }
                    // CTA for Toast Warning
                    ArcanaToastStyle.WARNING -> {
                        binding.customToastImage.setImageDrawable(
                            ContextCompat.getDrawable(
                                context,
                                R.drawable.ic_warning_yellow
                            )
                        )
                        DrawableCompat.setTint(
                            DrawableCompat.wrap(binding.customToastImage.drawable),
                            ContextCompat.getColor(context, warningToastColor)
                        )
                        startPulseAnimation(context, binding.customToastImage)
                        binding.colorView.backgroundTintList =
                            ContextCompat.getColorStateList(context, warningToastColor)

                        setBackgroundAndFilter(
                            R.drawable.toast_round_background,
                            R.color.dark_bg_color, layout, context
                        )

                        binding.customToastText.setTextColor(
                            ContextCompat.getColor(
                                context,
                                warningToastColor
                            )
                        )
                        binding.customToastText.text =
                            if (title.isNullOrBlank()) ArcanaToastStyle.WARNING.getName() else title

                        setDescriptionDetails(
                            font,
                            Color.WHITE,
                            message,
                            binding.customToastDescription
                        )

                        val toast = Toast(context.applicationContext)
                        startTimer(duration, toast)

                        setGravity(position, toast)
                        toast.view = layout//setting the view of custom toast layout
                        toast.show()
                    }
                    // CTA for Toast Info
                    ArcanaToastStyle.INFO -> {
                        binding.customToastImage.setImageDrawable(
                            ContextCompat.getDrawable(
                                context,
                                R.drawable.ic_info_blue
                            )
                        )
                        DrawableCompat.setTint(
                            DrawableCompat.wrap(binding.customToastImage.drawable),
                            ContextCompat.getColor(context, infoToastColor)
                        )
                        startPulseAnimation(context, binding.customToastImage)

                        binding.colorView.backgroundTintList =
                            ContextCompat.getColorStateList(context, infoToastColor)

                        setBackgroundAndFilter(
                            R.drawable.toast_round_background,
                            R.color.dark_bg_color, layout, context
                        )

                        binding.customToastText.setTextColor(
                            ContextCompat.getColor(
                                context,
                                infoToastColor
                            )
                        )
                        binding.customToastText.text =
                            if (title.isNullOrBlank()) ArcanaToastStyle.INFO.getName() else title

                        setDescriptionDetails(
                            font,
                            Color.WHITE,
                            message,
                            binding.customToastDescription
                        )

                        val toast = Toast(context.applicationContext)
                        startTimer(duration, toast)

                        setGravity(position, toast)
                        toast.view = layout//setting the view of custom toast layout
                        toast.show()
                    }
                    // CTA for Toast Delete
                    ArcanaToastStyle.DELETE -> {
                        binding.customToastImage.setImageDrawable(
                            ContextCompat.getDrawable(
                                context,
                                R.drawable.ic_delete_
                            )
                        )
                        DrawableCompat.setTint(
                            DrawableCompat.wrap(binding.customToastImage.drawable),
                            ContextCompat.getColor(context, deleteToastColor)
                        )
                        startPulseAnimation(context, binding.customToastImage)
                        binding.colorView.backgroundTintList =
                            ContextCompat.getColorStateList(context, deleteToastColor)

                        setBackgroundAndFilter(
                            R.drawable.toast_round_background,
                            R.color.dark_bg_color, layout, context
                        )

                        binding.customToastText.setTextColor(
                            ContextCompat.getColor(
                                context,
                                deleteToastColor
                            )
                        )
                        binding.customToastText.text =
                            if (title.isNullOrBlank()) ArcanaToastStyle.DELETE.getName() else title

                        setDescriptionDetails(
                            font,
                            Color.WHITE,
                            message,
                            binding.customToastDescription
                        )

                        val toast = Toast(context.applicationContext)
                        startTimer(duration, toast)

                        setGravity(position, toast)
                        toast.view = layout//setting the view of custom toast layout
                        toast.show()
                    }
                    // CTA for Toast No Internet
                    ArcanaToastStyle.NO_INTERNET -> {
                        binding.customToastImage.setImageDrawable(
                            ContextCompat.getDrawable(
                                context,
                                R.drawable.ic_no_internet
                            )
                        )
                        DrawableCompat.setTint(
                            DrawableCompat.wrap(binding.customToastImage.drawable),
                            ContextCompat.getColor(context, warningToastColor)
                        )
                        startPulseAnimation(context, binding.customToastImage)
                        binding.colorView.backgroundTintList =
                            ContextCompat.getColorStateList(context, warningToastColor)

                        setBackgroundAndFilter(
                            R.drawable.toast_round_background,
                            R.color.dark_bg_color, layout, context
                        )

                        binding.customToastText.setTextColor(
                            ContextCompat.getColor(
                                context,
                                warningToastColor
                            )
                        )
                        binding.customToastText.text =
                            if (title.isNullOrBlank()) ArcanaToastStyle.NO_INTERNET.getName() else title

                        setDescriptionDetails(
                            font,
                            Color.WHITE,
                            message,
                            binding.customToastDescription
                        )
                        val toast = Toast(context.applicationContext)
                        startTimer(duration, toast)

                        setGravity(position, toast)
                        toast.view = layout//setting the view of custom toast layout
                        toast.show()
                    }
                }
            }


*/




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
            /*   }
               else if (position == GRAVITY_TOP){
                   toast.setGravity(position, 0, 100)
               }
               else {
                   toast.setGravity(position, 0, 100)
               }*/
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

