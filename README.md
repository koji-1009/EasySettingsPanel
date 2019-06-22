# EasySettingsPanel

[![](https://jitpack.io/v/koji-1009/EasySettingsPanel.svg)](https://jitpack.io/#koji-1009/EasySettingsPanel)

Util class to use [Settings.Panel](https://developer.android.com/reference/android/provider/Settings.Panel) easily.

## Screen

<img src="https://user-images.githubusercontent.com/17231507/59960676-a6113a00-9506-11e9-8144-ab785719a84d.gif" width="300">

## Gradle

Step1. Add it in your root build.gradle at the end of repositories:

```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

Step2. Add the dependency

```groovy
dependencies {
    implementation 'com.github.koji-1009:EasySettingsPanel:Tag'
}
```


## How to use

```kotlin
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        button_internet_connectivity.setOnClickListener {
            EasySettingsPanel.openInternetConnectivityPanelBackportWifi(this@MainActivity)
        }
        button_nfc.setOnClickListener {
            if (NfcAdapter.getDefaultAdapter(this@MainActivity)?.isEnabled == true) {
                EasySettingsPanel.openNfcPanel(this@MainActivity)
            } else {
                Snackbar.make(layout_top, "Sorry. This phone can not use NFC.", Snackbar.LENGTH_INDEFINITE).show()
            }
        }
        button_volume.setOnClickListener {
            EasySettingsPanel.openVolumePanel(this@MainActivity)
        }
        button_wifi.setOnClickListener {
            EasySettingsPanel.openWifiPanel(this@MainActivity)
        }
    }
}
```

## License

Apache License 2.0

```text
Copyright (C) 2019 Koji Wakamiya

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
