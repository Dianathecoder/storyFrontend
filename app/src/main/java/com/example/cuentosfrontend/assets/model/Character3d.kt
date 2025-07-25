package com.example.cuentosfrontend.assets.model

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.xr.compose.platform.LocalSession
import androidx.xr.compose.spatial.Subspace
import androidx.xr.compose.subspace.SpatialPanel
import androidx.xr.compose.subspace.Volume
import androidx.xr.compose.subspace.layout.SubspaceModifier
import androidx.xr.compose.subspace.layout.height
import androidx.xr.compose.subspace.layout.movable
import androidx.xr.compose.subspace.layout.offset
import androidx.xr.compose.subspace.layout.resizable
import androidx.xr.compose.subspace.layout.scale
import androidx.xr.compose.subspace.layout.width
import kotlinx.coroutines.launch


//Para colocar un objeto 3D en tu diseño, deberás usar un elemento componible de subespacio llamado volumen.
@Composable
fun Character3d() {
    val session = checkNotNull(LocalSession.current)
    val scope = rememberCoroutineScope()

    Subspace {
        SpatialPanel(
            SubspaceModifier.height(1500.dp).width(1500.dp)
                .resizable().movable()
        ) {

            ObjectInAVolume(true)
            Box(
                Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Welcome",
                    fontSize = 50.sp,
                )
            }
        }
    }

}


@Composable
fun ObjectInAVolume(show3DObject: Boolean) {
    // [START_EXCLUDE silent]
    val volumeXOffset = 0.dp
    val volumeYOffset = 0.dp
    val volumeZOffset = 0.dp
    val session = checkNotNull(LocalSession.current)
    val scope = rememberCoroutineScope()
    if (show3DObject) {
        Subspace {
            Volume(
                modifier = SubspaceModifier
                    .offset(volumeXOffset, volumeYOffset, volumeZOffset) // Relative position
                    .scale(1.2f) // Scale to 120% of the size

            ) { parent ->
                scope.launch {
                    CargarModelo3D(session) { modelEntity ->
                        // Posicionamos el modelo en el subespacio
                        modelEntity.setParent(parent)

                        // Load your 3D model here
                    }
                }
            }
        }
    }
}

