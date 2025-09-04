package com.example.lab_week_01

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameDisplay: TextView = findViewById(R.id.name_display)
        val studentNumberDisplay: TextView = findViewById(R.id.student_number_display) // New TextView

        val nameInputLayout: TextInputLayout = findViewById(R.id.name_input_layout)
        val nameInputEditText: TextInputEditText = findViewById(R.id.name_input)

        val studentNumberInputLayout: TextInputLayout = findViewById(R.id.student_number_input_layout) // New
        val studentNumberInputEditText: TextInputEditText = findViewById(R.id.student_number_input) // New

        val submitButton: Button = findViewById(R.id.submit_button) // Renamed button

        submitButton.setOnClickListener {
            val nameInput = nameInputEditText.text.toString().trim()
            val studentNumberInput = studentNumberInputEditText.text.toString().trim()

            var isValid = true // Flag to check overall validity

            // Validate Name
            if (nameInput.isNotEmpty()) {
                nameDisplay.text = getString(R.string.name_greet).plus(" ").plus(nameInput)
                nameInputLayout.error = null // Clear error if previously set
            } else {
                nameInputLayout.error = getString(R.string.name_empty) // Show error on TextInputLayout
                isValid = false
            }

            // Validate Student Number
            if (studentNumberInput.length == 11) {
                studentNumberDisplay.text = getString(R.string.student_number_display_text, studentNumberInput)
                studentNumberInputLayout.error = null // Clear error if previously set
            } else {
                studentNumberDisplay.text = "" // Clear previous student number display
                studentNumberInputLayout.error = getString(R.string.student_number_error) // Show error
                isValid = false
            }

            // If both are valid, you could show a combined Toast or perform another action
            if (isValid) {
                Toast.makeText(this, "Details Submitted!", Toast.LENGTH_SHORT).show()
            } else {
                // Optionally, you can still show a general Toast if there are any errors,
                // or rely on the TextInputLayout errors.
                // Toast.makeText(this, "Please correct the errors.", Toast.LENGTH_LONG)
                //    .apply {
                //        setGravity(Gravity.CENTER, 0, 0)
                //        show()
                //    }
            }
        }
    }
}
