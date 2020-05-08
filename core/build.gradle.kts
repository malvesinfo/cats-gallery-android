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
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}


dependencies {

    api(KotlinX.kotlinStdLib)
    api(AndroidX.appCompat)
    api(AndroidX.ktxCore)
    api(AndroidX.constraintLayout)
    api(AndroidX.viewModel)
    api(AndroidX.liveData)
    api(AndroidX.activity)
    api(AndroidX.reactiveStreams)
    api(AndroidX.recyclerView)
    api(UI.material)
    api(UI.glide)

    api(React.rxAndroid)
    api(React.rxKotlin)

    testImplementation (TestLibraries.junit4)
    androidTestImplementation (TestLibraries.testRunner)
    androidTestImplementation (TestLibraries.espresso)
}