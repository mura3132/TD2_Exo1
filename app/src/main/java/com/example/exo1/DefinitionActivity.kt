package com.example.exo1

import android.media.MediaPlayer
import android.widget.MediaController
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_definition.*

class DefinitionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_definition)

        val word = intent.getSerializableExtra("word") as Word

        soundOn.setOnClickListener {
            val player : MediaPlayer = MediaPlayer.create(this, word.soundId)

            player.start()
        }


        wordTitle.text = word.title
        wordDefinition.text = word.definition
        wordImage.setImageResource(word.imageId)

        if (word.isVideo){
            wordVideo.visibility = View.VISIBLE
            val videoPath = "android.resource://"+packageName+"/"+word.videoId
            val uri = Uri.parse(videoPath)
            wordVideo.setVideoURI(uri)

            val mc = MediaController(this)
            wordVideo.setMediaController(mc)

        }else{
            wordVideo.visibility = View.GONE
        }


    }
}
