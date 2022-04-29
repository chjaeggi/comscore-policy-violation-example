package com.strange.comscoreapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import com.comscore.Analytics

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        Analytics.notifyViewEvent()  // gives me an IncorrectContextUseViolation and an UntaggedSocketViolation
    }
}