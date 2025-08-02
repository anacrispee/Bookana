plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("custom-gradle-plugin") {
            id = "custom-gradle-plugin"
            implementationClass = "CustomGradlePlugin"
        }
    }
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.0")
    implementation("com.android.tools.build:gradle:8.6.0")
}