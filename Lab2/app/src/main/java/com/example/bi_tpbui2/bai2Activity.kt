package com.example.bi_tpbui2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Bai2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bai2)

        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val errorTextView = findViewById<TextView>(R.id.errorTextView)
        val checkButton = findViewById<Button>(R.id.checkButton)

        checkButton.setOnClickListener {
            val email = emailEditText.text.toString()

            when {
                email.isEmpty() -> errorTextView.text = "Email không hợp lệ"
                !email.contains("@") -> errorTextView.text = "Email không đúng định dạng"
                else -> errorTextView.text = "Bạn đã nhập email hợp lệ"
            }
        }
        val btnGoToBai3 = findViewById<Button>(R.id.btnGoToBai3)
        btnGoToBai3.setOnClickListener {
            val intent = Intent(this, Bai3Activity::class.java)
            startActivity(intent)
        }
        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish() // Quay lại màn hình trước đó (MainActivity)
        }
    }
}
