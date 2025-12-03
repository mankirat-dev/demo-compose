plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
//    kotlin("jvm") version "2.2.0"
    kotlin("plugin.serialization") version "2.2.0"
}

android {
    namespace = "com.utdb.tt2"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.utdb.tt2"
        minSdk = 28
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            buildConfigField("String", "BASE_URL", "\"https://utdbtravelapi.dilonline.in\"")
        }
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "BASE_URL",  "\"https://utdbtravelapi.dilonline.in\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation("androidx.navigation:navigation-compose:2.9.0")
    implementation ("androidx.core:core-splashscreen:1.0.1")
    implementation("androidx.compose.material3:material3:1.2.1")

    implementation("io.ktor:ktor-client-core:3.2.1")
    implementation("io.ktor:ktor-client-android:3.2.1")
    implementation("io.ktor:ktor-client-serialization:3.2.1")
    implementation("io.ktor:ktor-client-logging:3.2.1")
    implementation("io.ktor:ktor-client-content-negotiation:3.2.1")
//    implementation("ch.qos.logback:logback-classic:1.5.18")

    implementation("androidx.compose.material:material-icons-extended:1.7.8")

    implementation("io.ktor:ktor-client-cio:3.2.1")
    implementation("io.ktor:ktor-serialization-kotlinx-json:3.2.1")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.1")

    implementation("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.9.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    implementation("com.google.dagger:hilt-android:2.56.2")
    kapt("com.google.dagger:hilt-compiler:2.56.2")

}