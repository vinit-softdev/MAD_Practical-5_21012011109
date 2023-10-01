package com.example.mad_practical_5_21012011109

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonBrowse: Button =findViewById(R.id.button_browse)
        val editurl: EditText =findViewById(R.id.edittexturl)
        buttonBrowse.setOnClickListener { openBrowser(editurl.text.toString()) }

        val buttonCall : Button =findViewById(R.id.button_call)
        val editCall : EditText = findViewById(R.id.editcall)
        buttonCall.setOnClickListener{ doCall(editCall.text.toString())}

        val buttonOpenCallLog : Button =findViewById(R.id.button_callLog)
        buttonOpenCallLog.setOnClickListener{openCallLog()}

        val buttonGallery : Button = findViewById(R.id.button_gallery)
        buttonGallery.setOnClickListener { openGallery() }

        val buttonCamera : Button =findViewById(R.id.button_camera)
        buttonCamera.setOnClickListener { openCamera() }

        val buttonAlarm : Button =findViewById(R.id.button_alarm)
        buttonAlarm.setOnClickListener { openAlarm() }
    }
    fun openBrowser(url:String){
        Intent(Intent.ACTION_VIEW, Uri.parse(url)).also { startActivity(it) }

    }

    fun doCall(number:String){
        Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:$number")).also { startActivity(it) }

    }

    fun openCallLog(){
        Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also { startActivity(it) }

    }

    fun openGallery(){
        Intent(Intent.ACTION_VIEW).setType("image/*").also { startActivity(it) }

    }

    fun openCamera(){
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { startActivity(it) }

    }

    fun openAlarm(){
        Intent(AlarmClock.ACTION_SHOW_ALARMS).also { startActivity(it) }

    }


}