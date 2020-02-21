plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(Config.compileVersion)
    buildToolsVersion = Config.buildToolVersion

    defaultConfig {
        applicationId = "com.hades.presentation"
        minSdkVersion(Config.minSdk)
        targetSdkVersion(Config.targetSdk)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.kotlin_stdlib)
    implementation(Libs.appcompat)
    implementation(Libs.core_ktx)
    implementation(Libs.constraint_layout)
    implementation(Libs.recyclerview)
    implementation(Libs.material)
    implementation(Libs.cardview)
    implementation(Libs.rxjava)
    implementation(Libs.retrofit)
    implementation(Libs.gson_converter)
    implementation(Libs.logging_interceptor)
    implementation(Libs.rxjava_adapter)
    implementation(Libs.room_runtime)
    implementation(Libs.rxandroid)
    implementation(Libs.lifecycle)
    implementation(Libs.picasso)
    implementation(Libs.koin_core)
    implementation(Libs.koin_android)
    implementation(Libs.koin_viewmodel)
    testImplementation(Libs.junit)
    testImplementation(Libs.mockito)
    androidTestImplementation(Libs.test_junit)
    androidTestImplementation(Libs.test_expresso)
    androidTestImplementation(Libs.mockito_android)
    androidTestImplementation(Libs.test_expresso)

    implementation(project(":data"))
    implementation(project(":domain"))
}
