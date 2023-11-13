package com.example.lab11

import android.content.ClipData.Item
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab11.databinding.ActivityTest03Binding
import com.example.lab11.databinding.ItemBinding

class Test03 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTest03Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //리사이클러 뷰를 쓰기 위해서 가상의 데이터 준비

        val data = mutableListOf<String>()
        for(i in 1..10){
            data.add("Item $i")
        }

        //레이아웃 매니저, 어뎁터
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MyAdapter(data)

        //데코레이션 (항목별로 선긋기)
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))


    }
}


//항목에 뷰를 가지고 있는 뷰홀더 준비하기

class MyViewHolder(val binding: ItemBinding): RecyclerView.ViewHolder(binding.root)

class  MyAdapter(val data : MutableList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun getItemCount(): Int {
        return data.size
    }


    //뷰홀더 개체 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }


    //아이템 데이터를 화면에 바인딩
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding
        binding.itemData.text = data[position]
    }










}
