package com.example.lab08.test01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import com.example.lab08.R

class MainActivity_test01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_test01)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN -> {
                Log.d("Hanto", "touch down x: ${event.x}, rawX: ${event.rawX}")
            }

            MotionEvent.ACTION_UP -> {
                Log.d("Hanto", "touch up x: ${event.x}, rawX: ${event.rawX}")
            }
        }
        return super.onTouchEvent(event)
    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when(keyCode){
            KeyEvent.KEYCODE_BACK -> Log.d("Hanto", "back button click...")
            KeyEvent.KEYCODE_VOLUME_UP -> Log.d("Hanto", "volume up click...")
            KeyEvent.KEYCODE_VOLUME_DOWN -> Log.d("Hanto", "volume down click...")
        }

        return super.onKeyDown(keyCode, event)
    }
}