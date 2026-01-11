package com.flashcardkids.util

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.speech.tts.TextToSpeech
import java.util.Locale

object AudioUtils {
    private var mediaPlayer: MediaPlayer? = null
    private var textToSpeech: TextToSpeech? = null

    fun initTTS(context: Context, onInit: (Boolean) -> Unit = {}) {
        textToSpeech = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                textToSpeech?.language = Locale.US
                onInit(true)
            } else {
                onInit(false)
            }
        }
    }

    fun speak(text: String) {
        textToSpeech?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
    }

    fun playAudio(context: Context, audioUri: Uri) {
        stopAudio()
        mediaPlayer = MediaPlayer().apply {
            setDataSource(context, audioUri)
            prepare()
            start()
            setOnCompletionListener {
                releaseMediaPlayer()
            }
        }
    }

    fun stopAudio() {
        mediaPlayer?.let {
            if (it.isPlaying) {
                it.stop()
            }
            releaseMediaPlayer()
        }
    }

    private fun releaseMediaPlayer() {
        mediaPlayer?.release()
        mediaPlayer = null
    }

    fun release() {
        stopAudio()
        textToSpeech?.stop()
        textToSpeech?.shutdown()
        textToSpeech = null
    }
}