package com.example.lab13

import android.app.Instrumentation.ActivityResult
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.lab13.databinding.ActivityTest01Binding

class test01Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTest01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //되돌아 오는 런처 이용하는 방법

        val requestLauncher : ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){

            //콜백등록
            val resultData = it.data?.getStringExtra("result")
            binding.resultView.text = "result : $resultData"
        }

        binding.button.setOnClickListener {
            //인텐트 정리->디테일엑티비티 실행시키는
            val intent = Intent(this, DetailActivity::class.java)
            //넘길데이터
            intent.putExtra("data1", "hello I'm Hanto")
            intent.putExtra("data2",22)
            requestLauncher.launch(intent)
        }


    }
}