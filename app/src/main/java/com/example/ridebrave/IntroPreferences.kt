package com.example.ridebrave

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

class IntroPreferences (_context: Context) {
    private val privateMode = 0;
    private val prefName = "Pref Name"
    private val firstTimeLaunch = "First launch"

    val context: Context = _context
    private val preferences: SharedPreferences = context.getSharedPreferences(prefName, privateMode)
    private val editor: Editor = preferences.edit()

    fun setFirstTimeLaunch(isFirstTimeLaunch : Boolean) {
        editor.putBoolean(firstTimeLaunch, isFirstTimeLaunch)
        editor.commit()
    }

    fun isFirstTimeLaunch() : Boolean {
        return preferences.getBoolean(firstTimeLaunch, true)
    }

}