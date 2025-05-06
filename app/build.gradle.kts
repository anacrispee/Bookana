plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("custom-gradle-plugin")
}

android {
    namespace = "com.example.bookana"
}

dependencies {
    implementation(project(path = ":feature_bookshelf"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
}