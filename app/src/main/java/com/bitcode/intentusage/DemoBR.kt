package com.bitcode.intentusage

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class DemoBR : BroadcastReceiver(){

    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(
            context,
            "DemoBR: ${intent!!.getStringExtra("path")}",
            Toast.LENGTH_LONG
        ).show()
    }
}