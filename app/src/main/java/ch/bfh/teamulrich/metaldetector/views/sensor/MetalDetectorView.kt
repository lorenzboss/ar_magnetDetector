package ch.bfh.teamulrich.metaldetector.views.sensor

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import ch.bfh.teamulrich.metaldetector.viewmodels.MetalDetectorState
import ch.bfh.teamulrich.metaldetector.viewmodels.MetalDetectorViewModel
import kotlin.math.min

val MetalDetectorState.progress: Float
    get() = min((this.currentMagnitude / this.maxMagnitude).toFloat(), 1.0f)

@Composable
fun MetalDetectorView(viewModel: MetalDetectorViewModel = viewModel()) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        state.let { currentState ->
            MetalDetectorInfoView(state = currentState)
            MetalDetectorProgressBar(progress = currentState.progress)
        }
    }
}