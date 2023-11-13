package com.example.lab10

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.lab10.databinding.ActivityTest03Binding
import com.example.lab10.databinding.DialogInputBinding

class Test03 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTest03Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button1.setOnClickListener {
            val items = arrayOf("스플랜더", "티츄", "렉시오", "스컬킹")
            val checkedItems = booleanArrayOf(false, false, false, false)

            AlertDialog.Builder(this).run {
                setTitle("What's your bias")
                setIcon(android.R.drawable.ic_dialog_alert)
                setMultiChoiceItems(
                    items,
                    checkedItems,
                    object : DialogInterface.OnMultiChoiceClickListener {
                        override fun onClick(dialog: DialogInterface?, which: Int, isChecked: Boolean) {
                            Log.d("Hanto", "${items[which]}이 선택되었습니다.")
                        }
                    }
                )
                setPositiveButton("닫기", null)
                show()
            }
        }

        binding.button2.setOnClickListener {
            val dialogBinding = DialogInputBinding.inflate(layoutInflater)
            AlertDialog.Builder(this).run{
                setTitle("input")
                setView(dialogBinding.root)
                setPositiveButton("닫기",null)
                show()
            }

        }


    }
}