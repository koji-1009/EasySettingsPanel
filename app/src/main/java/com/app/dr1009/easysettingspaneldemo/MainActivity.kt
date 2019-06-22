package com.app.dr1009.easysettingspaneldemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.dr1009.easysettingspanel.EasySettingsPanel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        button_internet_connectivity.setOnClickListener {
            EasySettingsPanel.openInternetConnectivityPanel(
                this@MainActivity,
                EasySettingsPanel.PreviousConnectivityMode.WIFI
            )
        }
        button_nfc.setOnClickListener {
            EasySettingsPanel.openNfcPanel(this@MainActivity)
        }
        button_volume.setOnClickListener {
            EasySettingsPanel.openVolumePanel(this@MainActivity)
        }
        button_wifi.setOnClickListener {
            EasySettingsPanel.openWifiPanel(this@MainActivity)
        }
    }
}
