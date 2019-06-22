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

    fun openInternetConnectivityPanel(context: Context) {
        context.startActivity(
            Intent(
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    Settings.Panel.ACTION_INTERNET_CONNECTIVITY
                } else {
                    Settings.ACTION_NETWORK_OPERATOR_SETTINGS
                }
            )
        )
    }

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