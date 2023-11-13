package com.example.lab10

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.RemoteInput
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.lab10.databinding.ActivityTest05Binding
import com.example.lab10.databinding.ActivityTest06Binding

class Test06 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTest06Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // 퍼미션 요청 다이얼로그를 띄우고 유저가 선택한 결과값을 받을 준비
        val permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            if (permissions.all { it.value }) {
                noti()
            } else {
                Toast.makeText(this, "Permission denied...", Toast.LENGTH_SHORT).show()
            }
        }

        binding.notificationButton.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                if (ContextCompat.checkSelfPermission(
                        this,
                        "android.permission.POST_NOTIFICATIONS"
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    noti()
                } else {
                    Toast.makeText(this, "권한을 허용해주세요>ㅁ<", Toast.LENGTH_SHORT).show()
                    permissionLauncher.launch(
                        arrayOf("android.permission.POST_NOTIFICATIONS")
                    )
                }
            } else { // 33버전 미만일 경우
                noti()
            }
        }
    }

    fun noti() {
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val builder: NotificationCompat.Builder
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "one"
            val channelName = "one channel"

            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "one description"
                setShowBadge(true)
                // 알림음
                val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val audioAttributes = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                setSound(uri, audioAttributes)
                enableVibration(true)
            }

            manager.createNotificationChannel(channel)
            // 오레오 이상 버전
            builder = NotificationCompat.Builder(this, channelId)
        } else {
            builder = NotificationCompat.Builder(this)
        }
        builder.run {
            setSmallIcon(R.drawable.hamster)
            setWhen(System.currentTimeMillis())
            setContentTitle("김한토")
            setContentText("토이루~!")
            setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.hamster))
        }

        // 리모트 인풋

        val KEY_TEXT_REPLY = "key_text_reply"
        val replyLabel = "답장"
        val remoteInput = androidx.core.app.RemoteInput.Builder(KEY_TEXT_REPLY)
            .setLabel(replyLabel)
            .build()

        // 리모트 인풋이 발생했을 때, 브로드캐스트 리시버가 실행되어야 하기 때문에 인텐트를 만든다.

        val replyIntent = Intent(this, ReplyReceiver::class.java)
        val replyPendingIntent = PendingIntent.getBroadcast(
            this, 30, replyIntent, PendingIntent.FLAG_MUTABLE
        )

        // 액션을 추가하고 액션에 리모트 인풋을 연결한다. 액션을 눌렀을 때 입력창이 뜬다.
        builder.addAction(
            NotificationCompat.Action.Builder(
                R.drawable.test,
                "답장",
                replyPendingIntent
            ).addRemoteInput(remoteInput).build()
        )

        // 노티피케이션 발생시키기

        manager.notify(11, builder.build())
    }
}
