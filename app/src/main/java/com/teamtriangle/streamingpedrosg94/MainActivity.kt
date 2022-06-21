package com.teamtriangle.streamingpedrosg94

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.appcompat.app.AppCompatActivity
import com.pedro.rtplibrary.rtsp.RtspCamera1
import com.pedro.rtsp.utils.ConnectCheckerRtsp

@SuppressLint("StaticFieldLeak")
private lateinit var rtspCamera1: RtspCamera1

class MainActivity : AppCompatActivity(), ConnectCheckerRtsp, SurfaceHolder.Callback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val surfaceView: SurfaceView = findViewById(R.id.surfaceView)
        rtspCamera1 = RtspCamera1(surfaceView, this)

        surfaceView.holder.addCallback(this);
    }

    override fun onAuthErrorRtsp() {

    }

    override fun onAuthSuccessRtsp() {

    }

    override fun onConnectionFailedRtsp(reason: String) {

    }

    override fun onConnectionStartedRtsp(rtspUrl: String) {

    }

    override fun onConnectionSuccessRtsp() {

    }

    override fun onDisconnectRtsp() {

    }

    override fun onNewBitrateRtsp(bitrate: Long) {

    }

    override fun surfaceCreated(p0: SurfaceHolder) {
        if (rtspCamera1.prepareAudio() && rtspCamera1.prepareVideo()) {
            rtspCamera1.startPreview()
            rtspCamera1.startStream("rtsp://192.168.178.54/test")
        }
    }

    override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {

    }

    override fun surfaceDestroyed(p0: SurfaceHolder) {
       rtspCamera1.stopStream()
    }
}