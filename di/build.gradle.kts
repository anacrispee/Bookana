plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("custom-gradle-plugin")
}

android {
    namespace = "com.example.di"
}

dependencies {
    implementation(project(path = ":domain"))
    implementation(project(path = ":data"))
    implementation(project(path = ":data_remote"))
    implementation(project(path = ":data_local"))
    implementation(project(path = ":feature_explore"))
    implementation(project(path = ":feature_bookshelf"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.android.koin)
    implementation(libs.android.koinCore)
    implementation(libs.android.okhttp)
    implementation(libs.android.retrofit2)
    implementation(libs.androidx.room)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}