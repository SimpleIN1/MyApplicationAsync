package com.example.myapplicationasync

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val startButton = findViewById<Button>(R.id.startButton)
        val stopButton = findViewById<Button>(R.id.stopButton)
        val textView = findViewById<TextView>(R.id.textViewValue)
        var i = 0
        var thread:Thread? = null

        startButton.setOnClickListener {
            thread = thread {
                while(i < 10){
                    try{
                        Thread.sleep(1000)
                    } catch (e: InterruptedException){
                        return@thread
                    }
                    runOnUiThread{
                        textView.text = i.toString()
                    }
                    i++
                }
            }
        }

        stopButton.setOnClickListener {
            thread?.interrupt()
        }
    }
}