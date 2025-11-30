plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android") version "2.0.21"
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.21"
    id("kotlin-kapt")
}

android {
    namespace = "com.example.cuentosfrontend"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.cuentosfrontend"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.7.3"
    }

    //  Configura Java y Kotlin al mismo nivel
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        jvmToolchain(17)

    }

    // Si usas una versión más vieja de Gradle y falla el bloque de arriba,
    // puedes dejar también este bloque adicional:
    kotlinOptions {
        jvmTarget = "17"

    }
}

dependencies {
    // Coil
    implementation("io.coil-kt:coil-compose:2.7.0")
    implementation("io.coil-kt:coil-gif:2.7.0")



    // Compose Core
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.animation:animation")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.ui:ui-text-google-fonts")
    implementation("androidx.compose.material:material-icons-extended")

    // Activity + Lifecycle
    implementation("androidx.activity:activity-compose:1.10.1")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.3")

    // Navigation
    implementation("androidx.navigation:navigation-compose:2.8.2")

    // Retrofit + OkHttp
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")

    // Lottie
    implementation("com.airbnb.android:lottie-compose:6.4.1")

    // Room con KSP
    implementation("androidx.room:room-runtime:2.7.0-alpha03")
    implementation("androidx.room:room-ktx:2.7.0-alpha03")

    // SceneView
    implementation("io.github.sceneview:sceneview:2.3.0")

    // MLKit Translation
    implementation("com.google.mlkit:translate:17.0.3")
    implementation(libs.androidx.work.runtime.ktx)
    implementation(libs.ads.mobile.sdk)

    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")

    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
