package ch.bfh.teamulrich.metaldetector.viewmodels

import android.app.Application
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import org.json.JSONObject

class QRCodeViewModel(application: Application) : AndroidViewModel(application) {
    var qrCode by mutableStateOf("")
        private set

    fun setCode(code: String) {
        this.qrCode = code
    }

    fun clearCode() {
        this.qrCode = ""
    }

    fun sendQRCodeToLogApp(context: Context) {
        val log = JSONObject()
        val intent: Intent?
        log.put("task", "Metalldetektor")
        log.put("solution", qrCode)
        intent = Intent("ch.apprun.intent.LOG")
        intent.putExtra("ch.apprun.logmessage", log.toString())
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        try {
            context.startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Log.e("LogBookError", " LogBook application is not installed on this device.")
        }
    }
}