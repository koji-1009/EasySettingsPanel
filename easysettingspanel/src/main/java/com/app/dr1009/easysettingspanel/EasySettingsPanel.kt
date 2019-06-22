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

/**
 * EasySettingsPanel is util class for Settings.Panel.
 */
object EasySettingsPanel {

    // region internet connectivity panel
    private enum class PreviousConnectivityMode {
        WIFI,
        MOBILE_DATA,
        AIRPLANE_MODE
    }

    /**
     * If phone is over Android Q, open Internet Connectivity Panel.
     * Otherwise, open UI that allows Wi-Fi to be turned on or off.
     *
     * @param context Context
     * @throws RuntimePermission In some cases, a matching Activity may not exist, so ensure you safeguard against this.
     */
    @Throws(RuntimeException::class)
    fun openInternetConnectivityPanelBackportWifi(context: Context) {
        openInternetConnectivityPanel(context, EasySettingsPanel.PreviousConnectivityMode.WIFI)
    }

    /**
     * If phone is over Android Q, open Internet Connectivity Panel.
     * Otherwise, open UI that allows Mobile data to be turned on or off.
     *
     * @param context Context
     * @throws RuntimePermission In some cases, a matching Activity may not exist, so ensure you safeguard against this.
     */
    @Throws(RuntimeException::class)
    fun openInternetConnectivityPanelBackportMobileData(context: Context) {
        openInternetConnectivityPanel(context, EasySettingsPanel.PreviousConnectivityMode.MOBILE_DATA)
    }

    /**
     * If phone is over Android Q, open Internet Connectivity Panel.
     * Otherwise, open UI that allows Airplane mode to be turned on or off.
     *
     * @param context Context
     * @throws RuntimePermission In some cases, a matching Activity may not exist, so ensure you safeguard against this.
     */
    @Throws(RuntimeException::class)
    fun openInternetConnectivityPanelBackportAirplane(context: Context) {
        openInternetConnectivityPanel(context, EasySettingsPanel.PreviousConnectivityMode.AIRPLANE_MODE)
    }

    @Throws(RuntimeException::class)
    private fun openInternetConnectivityPanel(context: Context, mode: PreviousConnectivityMode) {
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
    // endregion

    // region nfc panel
    /**
     * If phone is over Android Q, open NFC Panel.
     * Otherwise, open UI that allows NFC to be turned on or off.
     *
     * This method
     *
     * @param context Context
     * @throws RuntimePermission In some cases, a matching Activity may not exist, so ensure you safeguard against this.
     */
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
    // endregion

    // region volume panel
    /**
     * If phone is over Android Q, open Volume Panel.
     * Otherwise, open UI that allows NFC to be turned on or off.
     *
     * This method
     *
     * @param context Context
     * @throws RuntimePermission In some cases, a matching Activity may not exist, so ensure you safeguard against this.
     */
    @Throws(RuntimeException::class)
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
    // endregion

    // region wifi panel
    /**
     * If phone is over Android Q, open Wi-Fi Panel.
     * Otherwise, open UI that allows Wi-Fi to be turned on or off and select AccessPoint.
     *
     * This method
     *
     * @param context Context
     * @throws RuntimePermission In some cases, a matching Activity may not exist, so ensure you safeguard against this.
     */
    @Throws(RuntimeException::class)
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
    // endregion
}