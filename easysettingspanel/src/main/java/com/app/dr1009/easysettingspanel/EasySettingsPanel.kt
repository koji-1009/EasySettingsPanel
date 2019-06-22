/*
 * Copyright (C) 2019 Koji Wakamiya
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.app.dr1009.easysettingspanel

import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings

object EasySettingsPanel {

    enum class PreviousConnectivityMode {
        WIFI,
        MOBILE_DATA,
        AIRPLANE_MODE
    }

    fun openInternetConnectivityPanelWifi(context: Context) {
        openInternetConnectivityPanel(context, EasySettingsPanel.PreviousConnectivityMode.WIFI)
    }

    fun openInternetConnectivityPanelMobile(context: Context) {
        openInternetConnectivityPanel(context, EasySettingsPanel.PreviousConnectivityMode.MOBILE_DATA)
    }

    fun openInternetConnectivityPanelAirplane(context: Context) {
        openInternetConnectivityPanel(context, EasySettingsPanel.PreviousConnectivityMode.AIRPLANE_MODE)
    }

    fun openInternetConnectivityPanel(context: Context, mode: PreviousConnectivityMode) {
        context.startActivity(
            Intent(
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    Settings.Panel.ACTION_INTERNET_CONNECTIVITY
                } else {
                    when (mode) {
                        EasySettingsPanel.PreviousConnectivityMode.WIFI -> Settings.ACTION_WIFI_SETTINGS
                        EasySettingsPanel.PreviousConnectivityMode.MOBILE_DATA -> Settings.ACTION_NETWORK_OPERATOR_SETTINGS
                        EasySettingsPanel.PreviousConnectivityMode.AIRPLANE_MODE -> Settings.ACTION_AIRPLANE_MODE_SETTINGS
                    }
                }
            )
        )
    }

    @Throws(RuntimeException::class)
    fun openNfcPanel(context: Context) {
        context.startActivity(
            Intent(
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    Settings.Panel.ACTION_NFC
                } else {
                    Settings.ACTION_NFC_SETTINGS
                }
            )
        )
    }

    fun openVolumePanel(context: Context) {
        context.startActivity(
            Intent(
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    Settings.Panel.ACTION_VOLUME
                } else {
                    Settings.ACTION_SOUND_SETTINGS
                }
            )
        )
    }

    fun openWifiPanel(context: Context) {
        context.startActivity(
            Intent(
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    Settings.Panel.ACTION_WIFI
                } else {
                    Settings.ACTION_WIFI_SETTINGS
                }
            )
        )
    }
}