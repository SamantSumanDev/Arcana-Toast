package com.samant.arcanatoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.samant.arcana_toast.ArcanaToast
import com.samant.arcana_toast.ArcanaToastStyle


class MainActivity : AppCompatActivity() {
    private lateinit var btnSuccess: Button
    private lateinit var btnError: Button
    private lateinit var btnWarning: Button
    private lateinit var btnDelete: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSuccess = findViewById(R.id.btnSuccess)
        btnError = findViewById(R.id.btnError)
        btnWarning = findViewById(R.id.btnWarning)
        btnDelete = findViewById(R.id.btnDelete)

        btnSuccess.setOnClickListener {
            ArcanaToast.createToast(
                this,
                "Success",
                "Submited Successfully",
                ArcanaToastStyle.SUCCESS,
                ArcanaToast.GRAVITY_TOP,
                ArcanaToast.LONG_DURATION,
                ResourcesCompat.getFont(this, R.font.helvetica_regular)
            )
        }
        btnError.setOnClickListener {
            ArcanaToast.createToast(
                this,
                "Error",
                "Description",
                ArcanaToastStyle.ERROR,
                ArcanaToast.GRAVITY_TOP,
                ArcanaToast.LONG_DURATION,
                ResourcesCompat.getFont(this, R.font.helvetica_regular)
            )
        }
        btnWarning.setOnClickListener {
            ArcanaToast.createToast(
                this,
                "Warning",
                "Description",
                ArcanaToastStyle.WARNING,
                ArcanaToast.GRAVITY_TOP,
                ArcanaToast.LONG_DURATION,
                ResourcesCompat.getFont(this, R.font.helvetica_regular)
            )
        }
        btnDelete.setOnClickListener {
            ArcanaToast.createToast(
                this,
                "Delete",
                "Deleted successfully",
                ArcanaToastStyle.DELETE,
                ArcanaToast.GRAVITY_TOP,
                ArcanaToast.LONG_DURATION,
                ResourcesCompat.getFont(this, R.font.helvetica_regular)
            )
        }

    }
}