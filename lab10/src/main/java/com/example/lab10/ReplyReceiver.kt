package com.example.lab10



import android.app.NotificationManager
import android.app.RemoteInput
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class ReplyReceiver : BroadcastReceiver() {//브로드캐스트 메시지를 수신할 때 호출, 알람에 대한 답장을 처리

    override fun onReceive(context: Context, intent: Intent) {//알람에 대한 답장을 추출

        //replytext에는 사용자가 입력한 답장 내용이 포함된다.
        val replyText = RemoteInput.getResultsFromIntent(intent)?.getCharSequence("key_text_reply")
        Log.d("Hanto", "replytext : ${replyText}")


        //NotificationManager => 알림을 만들고 표시하며 관리하는데 사용되는 클래스
        val manager = context.getSystemService(AppCompatActivity.NOTIFICATION_SERVICE) as NotificationManager
        manager.cancel(11)



    }
}