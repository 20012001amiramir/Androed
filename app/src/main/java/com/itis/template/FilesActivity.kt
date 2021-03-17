package com.itis.template

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.files.*
import android.media.MediaPlayer
import android.os.Handler
import android.widget.Toast
import com.itis.template.MusicArray.MusicNamesArray.MusicNamesArray

class FilesActivity : AppCompatActivity() {
    private lateinit var player: MediaPlayer
    private lateinit var runnable:Runnable
    private var handler: Handler = Handler()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.files)
        val MusicName = MusicNamesArray[intent.getIntExtra("MusicNumber", -1)]
        button_play.setOnClickListener{

            when(MusicName){
                "0" -> player = MediaPlayer.create(applicationContext,R.raw.alfamist)
                "1" -> player = MediaPlayer.create(applicationContext,R.raw.brentfaiyaz)
                "2" -> player = MediaPlayer.create(applicationContext,R.raw.promise)

            }
            player.start()
            tv_duration.text = "${player.seconds} sec"
            initializeSeekBar()

            it.isEnabled = false
            button_stop.isEnabled = true

            player.setOnCompletionListener {
                button_stop.isEnabled = false
                button_play.isEnabled = true
                toast("end")
            }
        }


        button_stop.setOnClickListener{
            if(player.isPlaying){
                player.stop()
                player.reset()
                player.release()
                handler.removeCallbacks(runnable)

                it.isEnabled = false
                button_play.isEnabled = true
            }
        }
        seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (b) {
                    player.seekTo(i * 1000)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })
    }

    @SuppressLint("SetTextI18n")
    private fun initializeSeekBar() {
        seek_bar.max = player.seconds

        runnable = Runnable {
            seek_bar.progress = player.currentSeconds

            tv_pass.text = "${player.currentSeconds} sec"
            val diff = player.seconds - player.currentSeconds
            tv_due.text = "$diff sec"

            handler.postDelayed(runnable, 1000)
        }
        handler.postDelayed(runnable, 1000)
    }


    val MediaPlayer.seconds:Int
        get() {
            return this.duration / 1000
        }

    val MediaPlayer.currentSeconds:Int
        get() {
            return this.currentPosition/1000
        }

    fun Context.toast(message:String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}