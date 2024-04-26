package ch.bfh.teamulrich.metaldetector

import QRCameraView
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class CameraActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QRCameraView(onQRCodeResult = { _, value ->
                // TODO: set result and extra for the intent to be sent to LogBook app
                finish()
            })
        }

    }
}
