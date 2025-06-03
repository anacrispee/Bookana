plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("custom-gradle-plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.feature_explore"
}

dependencies {
    implementation(project(path = ":domain"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui)
    implementation(libs.coil)
    implementation(libs.android.koinCore)
    implementation(libs.android.koin)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}