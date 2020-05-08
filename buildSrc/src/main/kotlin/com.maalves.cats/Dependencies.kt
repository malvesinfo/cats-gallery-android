const val kotlinVersion = "1.3.21"

object Project {

    object Versions {
        const val buildToolsVersion = "3.3.1"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"

    const val androidApplication = "com.android.application"
    const val androidModule = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinKapt = "kotlin-kapt"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"

}

object AndroidSdk {
    const val min = 23
    const val compile = 28
    const val target = compile
}

object AndroidX {

    private object Versions {
        const val appcompat = "1.1.0"
        const val constraintLayout = "1.1.3"
        const val ktx = "1.2.0"
        const val lifecycle = "2.0.0"
        const val recyclerView = "1.0.0"
        const val swipeRefresh = "1.0.0"
    }

    const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"

    const val activity = "androidx.activity:activity-ktx:${Versions.appcompat}"

    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val recyclerView = "androidx.recyclerview:recyclerview-selection:${Versions.recyclerView}"
    const val swipeRefresh = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefresh}"

    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"

    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val liveData = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val reactiveStreams = "androidx.lifecycle:lifecycle-reactivestreams:${Versions.lifecycle}"
}

object KotlinX {
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
}

object UI {

    private object Versions {
        const val material = "1.1.0"
        const val glide = "4.11.0"
    }

    const val material = "com.google.android.material:material:${Versions.material}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
}

object React {

    private object Versions {
        const val rxAndroid = "2.1.1"
        const val rxKotlin = "2.4.0"
    }

    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}"
}

object Networking {

    private object Versions {
        const val retrofit = "2.5.0"
        const val okhttpLogging = "4.3.1"
    }

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitRx = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val converter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val logging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLogging}"
}

object TestLibraries {

    private object Versions {
        const val junit4 = "4.12"
        const val testRunner = "1.2.0"
        const val espresso = "3.2.0"
    }

    const val junit4 = "junit:junit:${Versions.junit4}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}