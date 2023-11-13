package com.example.lab10

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.lab10.databinding.ActivityTest02Binding
import java.time.Year

class Test02 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTest02Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val toast = Toast.makeText(this, "토스트 버튼을 눌렀습니다.",Toast.LENGTH_SHORT)
            toast.addCallback(
                object : Toast.Callback(){
                    override fun onToastHidden() {
                        super.onToastHidden()
                        Log.d("Hanto", "Toast hidden")

//                        toast.addCallback 메서드를 호출하여 Toast 메시지에 콜백을 추가합니다.
//
//                        object : Toast.Callback()을 사용하여 익명 클래스(Anonymous Inner Class)를 생성합니다. 이 익명 클래스는 Toast.Callback 클래스를 상속하고 있습니다.
//
//                        onToastHidden 메서드를 오버라이드하여 Toast 메시지가 화면에서 사라진 후에 실행할 코드를 정의합니다.
//
//                        Log.d("Hanto", "Toast hidden") 코드는 "Toast hidden" 메시지를 디버그 로그에 출력하는 역할을 합니다.
//
//                        즉, 이 코드는 Toast 메시지가 화면에서 사라진 순간에 "Toast hidden" 메시지를 로그에 출력하려고 사용됩니다. 이는 Toast 메시지가 표시된 후 사용자에게 보여진 시간을 추적하거나, 특정 이벤트가 발생할 때 추가적인 작업을 수행하기 위해 유용할 수 있습니다.
                    }

                    override fun onToastShown() {
                        super.onToastShown()
                        Log.d("Hanto", "Toast show")
                    }
                }
            )
            toast.show()
        }

        binding.button2.setOnClickListener {
            DatePickerDialog(this, object: DatePickerDialog.OnDateSetListener {
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    Log.d("Hanto", "Date : ${year}, ${month+1}, ${dayOfMonth}")
                }

            }, 2023, 8, 16).show()
        }

        binding.button3.setOnClickListener {
            TimePickerDialog(this, object:TimePickerDialog.OnTimeSetListener {
                override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                    Log.d("Hanto", "Time : ${hourOfDay}, ${minute}")
                }
            }, 6, 43, true).show()
        }



    }
}



