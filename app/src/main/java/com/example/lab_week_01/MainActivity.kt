package com.example.lab_week_01

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nameDisplay: TextView = findViewById(R.id.name_display)
        val nameSubmit: Button = findViewById(R.id.name_submit)
        val nameInputEditText: TextInputEditText = findViewById(R.id.name_input)
        nameSubmit.setOnClickListener {
            val nameInput = nameInputEditText.text.toString().trim()
            if (nameInput.isNotEmpty()) {
                nameDisplay.text = getString(R.string.name_greet).plus(" ").plus(nameInput)
// or you can use
// nameDisplay?.text = "${getString(R.string.name_greet)} ${nameInput}"
            } else {
                Toast.makeText(this, getString(R.string.name_empty), Toast.LENGTH_LONG)
                    .apply {
                        setGravity(Gravity.CENTER, 0, 0)
                        show()
                    }
            }
        }
    }
}