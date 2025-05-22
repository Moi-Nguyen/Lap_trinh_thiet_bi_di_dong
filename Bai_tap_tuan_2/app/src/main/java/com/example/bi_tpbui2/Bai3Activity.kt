package com.example.bi_tpbui2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Bai3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bai3)

        val edtName = findViewById<EditText>(R.id.edtName)
        val edtAge = findViewById<EditText>(R.id.edtAge)
        val btnCheck = findViewById<Button>(R.id.btnCheck)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        btnCheck.setOnClickListener {
            val name = edtName.text.toString().trim()
            val age = edtAge.text.toString().toIntOrNull()

            if (name.isEmpty() || age == null) {
                txtResult.text = "Vui lòng nhập đầy đủ thông tin hợp lệ."
            } else {
                val group = when {
                    age > 65 -> "Người già"
                    age in 7..65 -> "Người lớn"
                    age in 2..6 -> "Trẻ em"
                    age <= 2 -> "Em bé"
                    else -> "Không xác định"
                }
                txtResult.text = "$name thuộc nhóm: $group"
            }
        }
        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish() // Quay lại màn hình trước đó (MainActivity)
        }
    }
}
