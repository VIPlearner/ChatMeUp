package com.android.chatmeup

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.android.chatmeup.data.db.firebase_db.repository.DatabaseRepository
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import timber.log.Timber

const val channel_id = "notification_channel"
const val channel_name = "com.android.chatmeup"

class CmuFirebaseInstanceIDService: FirebaseMessagingService() {
    private val dbRepository: DatabaseRepository = DatabaseRepository()


    companion object{
        private val tag = CmuFirebaseInstanceIDService::class.java.simpleName
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        //update user info
        Timber.tag(tag).d("new Token: $token")
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            val refreshedToken = task.result
            Firebase.auth.currentUser?.let { dbRepository.updateFCMToken(it.uid, refreshedToken) }
        }
        //push notification to all contacts
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        Timber.tag(tag).d("message Received ${message.data}")
        //save to database
        //show notification if app is paused or closed
//        if(message.notification != null){
//            generateNotification()
//        }
    }

    override fun onMessageSent(msgId: String) {
        super.onMessageSent(msgId)
        Timber.tag(tag).d("message Sent $msgId")
        //update msg sent
    }

    override fun onSendError(msgId: String, exception: Exception) {
        super.onSendError(msgId, exception)
        Timber.tag(tag).d("message not Sent $msgId $exception")
    }

    private fun generateNotification() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE
        )
//        var message1 = NotificationCompat.MessagingStyle.Message(messages[0].getText(),
//            messages[0].getTime(),
//            messages[0].getSender())
//        var message2 = NotificationCompat.MessagingStyle.Message(messages[1].getText(),
//            messages[1].getTime(),
//            messages[1].getSender())

        val builder = NotificationCompat.Builder(this, channel_id)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setAutoCancel(true)
            .setVibrate(longArrayOf(1000, 1000, 1000, 1000))
            .setOnlyAlertOnce(true)
            .setContentText("test")
            .setContentTitle("Okay")
            .setContentIntent(pendingIntent)
            .build()

        val notificationManager =
            (applicationContext.getSystemService(Context.NOTIFICATION_SERVICE)) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                channel_id,
                channel_name,
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationManager.createNotificationChannel(notificationChannel)
        }
        notificationManager.notify(0, builder)
    }

//    fun sendPushNotification(token: String, title: String, subtitle: String, body: String, data: Map<String, String> = emptyMap()) {
//        val url = "https://fcm.googleapis.com/fcm/send"
//        val key = ""
//
//        val bodyJson = JSONObject()
//        bodyJson.put("to", token)
//        bodyJson.put("notification",
//            JSONObject().also {
//                it.put("title", title)
//                it.put("subtitle", subtitle)
//                it.put("body", body)
//                it.put("sound", "social_notification_sound.wav")
//            }
//        )
//        bodyJson.put("data", JSONObject(data))
//
//        val request = Request.Builder()
//            .url(url)
//            .addHeader("Content-Type", "application/json")
//            .addHeader("Authorization", "key=$key")
//            .post(
//                bodyJson.toString().toRequestBody("application/json; charset=utf-8".toMediaType())
//            )
//            .build()
//
//        val client = OkHttpClient()
//
//        client.newCall(request).enqueue(
//            object : Callback {
//                override fun onResponse(call: Call, response: Response) {
//                    println("Received data: ${response.body?.string()}")
//                }
//
//                override fun onFailure(call: Call, e: IOException) {
//                    println(e.message.toString())
//                }
//            }
//        )
//    }
}