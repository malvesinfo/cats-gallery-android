plugins {
    id(Project.androidModule)
    id(Project.kotlinAndroid)
    id(Project.kotlinAndroidExtensions)
    id(Project.kotlinKapt)
}

android {
    compileSdkVersion(AndroidSdk.compile)

    defaultConfig {
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        buildConfigField("String", "CLIENT_ID", "\"Client-ID 1ceddedc03a5d71\"")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}


dependencies {

    implementation(project(":core"))

    implementation(Networking.retrofit)
    implementation(Networking.converter)
    implementation(Networking.logging)
    implementation(Networking.retrofitRx)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)
}