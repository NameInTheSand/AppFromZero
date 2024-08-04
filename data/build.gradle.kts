plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies{

    implementation(libs.coroutines)

    implementation(libs.retrofit2)
    implementation(libs.gson)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logger)
    implementation(libs.koin.core)

//    //TEST
//    testImplementation (libs.junit.jupiter.engine)
//    testImplementation (libs.junit.vintage.engine)

    implementation(project(":domain"))

}