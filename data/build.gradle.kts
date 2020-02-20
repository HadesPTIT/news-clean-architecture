plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(Config.compileVersion)
    buildToolsVersion = Config.buildToolVersion

    defaultConfig {
        minSdkVersion(Config.minSdk)
        targetSdkVersion(Config.targetSdk)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
        buildConfigField("String", "API_KEY", "\"e71904384c3c4ad4b72c4b713fe815de\"")
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
    implementation(Libs.rxjava)
    implementation(Libs.retrofit)
    implementation(Libs.logging_interceptor)
    implementation(Libs.rxjava_adapter)
    implementation(Libs.gson_converter)
    implementation(Libs.room_runtime)
    implementation(Libs.room_rx)
    kapt(Libs.room_kapt_compiler)
    testImplementation(Libs.junit)
    androidTestImplementation(Libs.test_junit)
    androidTestImplementation(Libs.test_expresso)

    implementation(project(":domain"))
}
