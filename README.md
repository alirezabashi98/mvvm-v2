# mvvm-v2
Check offline and offline

## Used libraries

[RxAndroid: Reactive Extensions for Android](https://github.com/ReactiveX/RxAndroid)
    
[lifecycle extensions](https://developer.android.com/jetpack/androidx/releases/lifecycle)
    
[Koin for Android & Koin Android ViewModel features](https://github.com/InsertKoinIO/koin)

```

    // RxAndroid: Reactive Extensions for Android

    implementation 'io.reactivex.rxjava2:rxandroid:2.1.1'
    implementation 'io.reactivex.rxjava2:rxjava:2.2.8'

    // lifecycle extensions
    def lifecycle_version = "2.2.0"

    // ViewModel
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
    // LiveData
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"

    // Annotation processor
    kapt "androidx.lifecycle:lifecycle-compiler:$lifecycle_version"

    // Koin for Android & Koin Android ViewModel features
    def koin_version = "1.0.2"

    implementation "org.koin:koin-android:$koin_version"
    implementation "org.koin:koin-android-viewmodel:$koin_version"
```
