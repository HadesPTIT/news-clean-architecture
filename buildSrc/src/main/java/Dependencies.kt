object Config {
    const val minSdk = 15
    const val targetSdk = 28
    const val compileVersion = 29
    const val buildToolVersion = "29.0.1"
}

object Versions {
    const val kotlin = "1.3.50"
    const val gradle = "3.5.3"
    const val appcompat = "1.1.0"
    const val recyclerview = "1.1.0"
    const val material = "1.1.0"
    const val cardview = "1.0.0"
    const val core_ktx = "1.2.0"
    const val retrofit = "2.3.0"
    const val logging_interceptor = "3.8.0"
    const val gson_converter = "2.3.0"
    const val room = "2.0.0-beta01"
    const val constraint_layout = "1.1.3"
    const val lifecycle = "2.0.0-beta01"
    const val picasso = "2.5.2"
    const val rxjava = "2.1.6"
    const val rxandroid = "2.0.1"
    const val rxjava_adapter = "2.3.0"
    const val koin = "2.0.1"
    const val junit = "4.12"
    const val test_junit = "1.1.1"
    const val test_expresso = "3.2.0"
    const val mockito = "2.8.47"
    const val mockito_android = "2.18.3"
}

object Libs {
    const val kotlin_gradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val build_gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val cardview = "androidx.cardview:cardview:${Versions.cardview}"
    const val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val logging_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.logging_interceptor}"
    const val gson_converter = "com.squareup.retrofit2:converter-gson:${Versions.gson_converter}"
    const val room_runtime = "androidx.room:room-runtime:${Versions.room}"
    const val room_rx = "androidx.room:room-rxjava2:${Versions.room}"
    const val room_kapt_compiler = "androidx.room:room-compiler:${Versions.room}"
    const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val picasso = "com.squareup.picasso:picasso:${Versions.picasso}"
    // RxJava
    const val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"
    const val rxandroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"
    const val rxjava_adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.rxjava_adapter}"
    // DI- Koin
    const val koin_core = "org.koin:koin-core:${Versions.koin}"
    const val koin_android = "org.koin:koin-android:${Versions.koin}"
    const val koin_viewmodel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    // Testing
    const val junit = "junit:junit:${Versions.junit}"
    const val test_junit = "androidx.test.ext:junit:${Versions.test_junit}"
    const val test_expresso = "androidx.test.espresso:espresso-core:${Versions.test_expresso}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockito_android = "org.mockito:mockito-android:${Versions.mockito_android}"
}
