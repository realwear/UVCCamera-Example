/*
 * RealWear Development Software, Source Code and Object Code.
 * (c) RealWear, Inc. All rights reserved.
 *
 * Contact info@realwear.com for further information about the use of this code.
 */

package com.realwear.uvccameraexample

import android.hardware.usb.UsbDevice
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.serenegiant.usb.USBMonitor

/**
 * Main activity for the application
 *
 * This activity extends the UVCCamera library's USBMonitor.OnDeviceConnectListener so that
 * the application can respond to the USB camera's lifecycle events.
 */
class MainActivity : AppCompatActivity(), USBMonitor.OnDeviceConnectListener {
    private var mUSBMonitor: USBMonitor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mUSBMonitor = USBMonitor(this, this)
    }

    override fun onStart() {
        super.onStart()
        mUSBMonitor?.register()
    }

    override fun onStop() {
        mUSBMonitor?.unregister()
        super.onStop()
    }

    /**
     * Called when the camera is attached to the Android device
     */
    override fun onAttach(device: UsbDevice?) {
        Log.i(TAG, "Device has been attached")

        // When the camera is attached, we need to ask the user for permission to access it.
        mUSBMonitor?.requestPermission(device)
    }

    /**
     * Called when the camera connects
     */
    override fun onConnect(
        device: UsbDevice?,
        controlBlock: USBMonitor.UsbControlBlock?,
        createNew: Boolean
    ) {
        Log.i(TAG, "Device has been connected")
    }

    /**
     * Called when the camera connection is cancelled
     */
    override fun onCancel(device: UsbDevice?) {
        Log.i(TAG, "Device connection has been cancelled")
    }

    /**
     * Called when the camera disconnects
     */
    override fun onDisconnect(device: UsbDevice?, controlBlock: USBMonitor.UsbControlBlock?) {
        Log.i(TAG, "Device has disconnected")
    }

    /**
     * Called when the camera is detached
     */
    override fun onDettach(device: UsbDevice?) {
        Log.i(TAG, "Device has been detached")
    }

    companion object {
        const val TAG = "UvcCameraExample"
    }
}