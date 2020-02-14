package com.example.sportapitask.view.ui

import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.sportapitask.R
import com.example.sportapitask.data.models.domain.VideoModel
import com.example.sportapitask.utils.MyConsts
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.activity_video.*

class VideoActivity : AppCompatActivity() {

    private lateinit var video: VideoModel
    private lateinit var simpleExoPlayer: SimpleExoPlayer

    override fun onDestroy() {
        super.onDestroy()
        simpleExoPlayer.release()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFullScreen()
        setContentView(R.layout.activity_video)
        hideActionBar()
        getDataFromBundle()
        initPlayer()
    }

    private fun getDataFromBundle() {
        if (intent.hasExtra(MyConsts.EXTRA_VIDEO_MODEL)) {
            video = intent.getSerializableExtra(MyConsts.EXTRA_VIDEO_MODEL) as VideoModel
        }
    }

    private fun setFullScreen(){
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    private fun hideActionBar(){
        supportActionBar?.hide()
    }

    private fun initPlayer() {
        simpleExoPlayer= ExoPlayerFactory.newSimpleInstance(this)
        exo_player_view.player = simpleExoPlayer
        val dsFactory = DefaultDataSourceFactory(this, Util.getUserAgent(this, "SportAPITask"))
        val mediaSource = ExtractorMediaSource.Factory(dsFactory).createMediaSource(Uri.parse(video.url))
        simpleExoPlayer.prepare(mediaSource)
        simpleExoPlayer.playWhenReady = true
    }
}