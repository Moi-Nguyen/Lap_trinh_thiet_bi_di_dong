package com.example.bi_tpbui2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonGoToBai2 = findViewById<Button>(R.id.buttonGoToBai2)
        buttonGoToBai2.setOnClickListener {
            val intent = Intent(this, Bai2Activity::class.java)
            startActivity(intent)
        }
    }
}
