package com.ibk.app.core

import android.os.CountDownTimer
import android.util.Log

object HandlerSession {

    private var activeSession = false

    fun executeCountDownTimer(block: () -> Unit) {
        val seconds = 60
        val minutes = 2
        val time = seconds * minutes * 1000L
        val timer = object : CountDownTimer(time, 1000L) {

            override fun onTick(millisUntilFinished: Long) {
                val timeInSeconds = (millisUntilFinished / 1000).toInt()
                Log.e("TIMER_SESION", "_ $timeInSeconds")
            }

            override fun onFinish() {
                block.invoke()
                stateInactiveSession()
            }
        }
        timer.start()
    }

    fun stateActiveSession() {
        activeSession = true
    }

    fun stateInactiveSession() {
        activeSession = false
    }

    fun getStateSession(): Boolean {
        return activeSession
    }

}

