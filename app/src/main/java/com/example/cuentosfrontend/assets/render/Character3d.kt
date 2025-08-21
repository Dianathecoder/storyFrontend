package com.example.cuentosfrontend.assets.render

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
fun Character3d(modifier: Modifier = Modifier) {

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
    val volumeXOffset = 0.dp
    val volumeYOffset = 0.dp
    val volumeZOffset = 0.dp

    val session = checkNotNull(LocalSession.current)
    val scope = rememberCoroutineScope()

    // Este flag asegura que solo cargamos una vez el modelo
    val modelLoaded = remember { mutableStateOf(false) }

    if (show3DObject && !modelLoaded.value) {
        Subspace {
            Volume(
                modifier = SubspaceModifier
                    .offset(volumeXOffset, volumeYOffset, volumeZOffset)
                    .scale(3f)
            ) { parent ->
                scope.launch {
                    try {
                        cargarModelo3D(session) { modelEntity ->
                            modelEntity.setParent(parent)
                            modelLoaded.value = true
                            Log.d("Modelo3D", "Modelo insertado en el volumen correctamente")
                        }
                    } catch (e: Exception) {
                        Log.e("Modelo3D", "Error cargando modelo: ${e.message}", e)
                    }
                }
            }
        }
    }
}


