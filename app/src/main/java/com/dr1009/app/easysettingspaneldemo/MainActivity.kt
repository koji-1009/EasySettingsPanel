package com.dr1009.app.easysettingspaneldemo

import android.nfc.NfcAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dr1009.app.easysettingspanel.EasySettingsPanel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

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
