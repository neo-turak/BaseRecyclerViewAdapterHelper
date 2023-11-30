
plugins {
    id("com.android.library")
    kotlin("android")
    id("maven-publish")
}

group = "com.github.jitpack"
version = "3.0.19"

android {
    compileSdk = 31
    defaultConfig {
        minSdk = 14
        consumerProguardFiles("proguard-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    namespace = "com.chad.library"
}

dependencies {
    implementation("androidx.annotation:annotation:1.6.0")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.databinding:databinding-runtime:8.1.4")
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release"){
                from(components["release"])
                groupId = "com.neo-turak"
                artifactId = "BaseRecyclerViewAdapterHelper"
                version = "3.0.19"
            }
        }
    }
}

