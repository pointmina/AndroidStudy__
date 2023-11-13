package com.example.lab11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab11.databinding.ActivityTest02Binding

class ActivityTest02 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTest02Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //프레그먼트 제어하기

        //프레그먼트 얻기
        val fragment = OneFragment()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        //트랜젝션 객체에 R.id에 add리플레이스
        transaction.add(R.id.fragment_content, fragment)

        //꼭 커밋을 해야한다.
        transaction.commit()

    }
}