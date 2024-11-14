@file:Suppress("DEPRECATION")

plugins {
    alias(libs.plugins.android.library)   // uso el plugin de librería de Android
    alias(libs.plugins.kotlin.android)    // Uso el plugin de Kotlin para Android
}

android {
    namespace = "com.example.mybuttonlibrary"   // defino el namespace para la librería
    compileSdk = 35    // update el SDK de compilación a 35 (actualización necesaria)

    defaultConfig {
        minSdk = 30    // Versión mínima de SDK que soporta la librería
        targetSdk = 35 // defino la versión del SDK con la que se prueba la librería

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"  // configuración de pruebas instrumentadas
        consumerProguardFiles("consumer-rules.pro")   // el proguard para proteger el código cuando la librería se consuma
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"  // el archivo de reglas de proguard (opcional)
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11  // uso Java 11 para la librería
        targetCompatibility = JavaVersion.VERSION_11  // aseguro que el código se compile para Java 11
    }

    kotlinOptions {
        jvmTarget = "11"  // configuro Kotlin para usar la versión 11 de JVM
    }
}

dependencies {
    // Dependencias necesarias para la librería
    implementation(libs.androidx.core.ktx)  // la librería para extensiones de Android
    implementation(libs.androidx.appcompat)  // la librería de compatibilidad para Activity y Fragment
    implementation(libs.material)  // la librería para componentes de Material Design (como botones)
    implementation(libs.material.v160)  // asegúrate de que esta dependencia es válida (puedes omitirla si no la necesitas)

    // Dependencias de pruebas
    testImplementation(libs.junit)  // para pruebas unitarias
    androidTestImplementation(libs.androidx.junit)  // para pruebas instrumentadas
    androidTestImplementation(libs.androidx.espresso.core)  // para pruebas de interfaz (Espresso)
}
