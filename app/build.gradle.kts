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
    implementation(project(path = ":feature_explore"))
    implementation(project(path = ":di"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
    implementation(libs.android.koinCore)
    implementation(libs.android.koin)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

}