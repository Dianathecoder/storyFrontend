package com.example.cuentosfrontend.assets.render

import android.util.Log
import androidx.xr.runtime.Session
import androidx.xr.scenecore.GltfModel
import androidx.xr.scenecore.GltfModelEntity
import androidx.xr.scenecore.SpatialCapabilities
import androidx.xr.scenecore.scene
import kotlinx.coroutines.guava.await



suspend fun cargarModelo3D(

    session: Session,
    modelPath: String = "model/Dragonprueba.glb",
    onModelReady: (GltfModelEntity) -> Unit
) {

    // Cargar el modelo GLTF asincrónicamente
    val gltfModel = GltfModel.create(session, modelPath).await()

    Log.d("Modelo3D", "Modelo cargado correctamente")

    if (session.scene.spatialCapabilities
            .hasCapability(SpatialCapabilities.SPATIAL_CAPABILITY_3D_CONTENT)
    ) {
        val gltfEntity = GltfModelEntity.create(session, gltfModel)
        onModelReady(gltfEntity)  // Avisamos que el modelo está listo y enviamos la entidad
    }
}