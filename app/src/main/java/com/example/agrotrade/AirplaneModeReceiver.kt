package com.example.agrotrade

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplaneEnable = intent?.getBooleanExtra("state", false)?:return
        if(isAirplaneEnable){
            Toast.makeText(context,  "Airplane Mode Enabled", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "Airplane Mode Disabled", Toast.LENGTH_SHORT).show()
        }
        
    }
}