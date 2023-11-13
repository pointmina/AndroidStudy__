package com.example.lab13

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.example.lab13.databinding.ActivityTest01Binding
import com.example.lab13.databinding.ActivityTest03Binding

class test03Activity : AppCompatActivity() {
    lateinit var binding: ActivityTest03Binding
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTest03Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.countButton.setOnClickListener {
            count++
            binding.resultView.text = "$count"
        }
    }

    // 화면 회전시에 데이터 코드 저장
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
    }

    // 복원시켜주는 코드
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val data = savedInstanceState.getInt("count")
        binding.resultView.text = "$data"
    }
}
