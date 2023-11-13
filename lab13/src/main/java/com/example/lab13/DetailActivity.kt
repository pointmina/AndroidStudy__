package com.example.lab13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab13.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //다른쪽에서 실행하면 넘어오는 extra data

        val data1 = intent.getStringExtra("data1")
        val data2 = intent.getIntExtra("data2",0)

        binding.detailTextView.text = "$data1 , $data2"

        //버튼이 클릭되었을 때 종료시키고 결과데이터를 넘긴다.

        binding.detailButton.setOnClickListener {
            //결과데이터
            intent.putExtra("result", "world")

            //상태정보
            setResult(RESULT_OK,intent)
            finish()
        }

    }
}