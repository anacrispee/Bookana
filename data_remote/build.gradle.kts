plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("custom-gradle-plugin")
}

android {
    namespace = "com.example.data_remote"
}

dependencies {
    implementation(project(path = ":data"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.android.okhttp)
    implementation(libs.android.retrofit2)
    implementation(libs.android.koinCore)
    implementation(libs.android.gsonConvertFacotory)
    implementation(libs.android.httpInterceptor)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}