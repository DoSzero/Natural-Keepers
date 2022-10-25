package com.nak.naturalkeepers.utils

import android.content.Context
import android.content.SharedPreferences

fun Context.storeSharedPref(key: String, value: String?) {
    val sharedPref: SharedPreferences = getSharedPreferences("crosswordGame", Context.MODE_PRIVATE)
    val editor: SharedPreferences.Editor = sharedPref.edit()

    editor.putString(key, value)
    editor.apply()
}

fun Context.getSharedPrefString(key: String): String? {
    val sharedPref: SharedPreferences = getSharedPreferences("crosswordGame", Context.MODE_PRIVATE)
    return sharedPref.getString(key, null)
}

fun Context.storeSharedPref(key: String, value: Int) {
    val sharedPref: SharedPreferences = getSharedPreferences("crosswordGame", Context.MODE_PRIVATE)
    val editor: SharedPreferences.Editor = sharedPref.edit()

    editor.putInt(key, value)
    editor.apply()
}

fun Context.getSharedPrefInt(key: String): Int {
    val sharedPref: SharedPreferences = getSharedPreferences("crosswordGame", Context.MODE_PRIVATE)
    return sharedPref.getInt(key, -1)
}
