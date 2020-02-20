plugins {
    id("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}


dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Rx for flowable mapper
    implementation(Libs.kotlin_stdlib)
    implementation(Libs.rxjava)
    testImplementation(Libs.junit)
    testImplementation(Libs.mockito)
}

repositories {
    mavenCentral()
}