package com.raxx.myvoicerecorder

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaParser
import android.media.MediaPlayer
import android.media.MediaRecorder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File


class MainActivity : AppCompatActivity() {


    lateinit var mediaRecorder :MediaRecorder
    private var i=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start.isEnabled=false
        stop.isEnabled=false
        mediaRecorder= MediaRecorder()
        var path =  Environment.getExternalStorageDirectory().toString()+"/"+Environment.DIRECTORY_MUSIC+"/record"+i+".aac"
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.RECORD_AUDIO)!=PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.RECORD_AUDIO,
                                                                        Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE),0)
            Toast.makeText(applicationContext,"started",Toast.LENGTH_LONG).show()
        }
        start.isEnabled=true
        start.setOnClickListener{
            start.isEnabled = false
            rtext.text="Recording......"
            while(File(path).exists()){
                i++
                path= path.subSequence(0,32) as String
                path= "$path$i.aac"
            }

            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC)

            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)

            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)



            mediaRecorder.setOutputFile(path)
            mediaRecorder.prepare()
            mediaRecorder.start()

            stop.isEnabled = true

        }
        stop.setOnClickListener{
            stop.isEnabled = false
            mediaRecorder.stop()
            start.isEnabled=true
            rtext.text="Not Recording"

        }


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            start.isEnabled=true

        }
    }
}