
plugins {
    id("com.android.library")
    kotlin("android")
}

val versionName = "3.0.17"

android {
    compileSdk = 31
    defaultConfig {
        minSdk = 14
        consumerProguardFiles("proguard-rules.pro")
    }


    buildTypes {
        getByName("release") {
            consumerProguardFiles("proguard-rules.pro")
        }
    }


    compileOptions {
        kotlinOptions.freeCompilerArgs = ArrayList<String>().apply {
            add("-module-name")
            add("com.github.CymChad.brvah")
            add("-Xjvm-default=all")
        }
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    namespace = "com.chad.library"


    publishing {
        singleVariant("release") {
            // if you don't want sources/javadoc, remove these lines
            withSourcesJar()
            withJavadocJar()
        }
    }
}


dependencies {
    implementation("androidx.annotation:annotation:1.6.0")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.databinding:databinding-runtime:8.1.4")
}


