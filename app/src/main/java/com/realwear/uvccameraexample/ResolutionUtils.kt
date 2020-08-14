package com.realwear.uvccameraexample

import com.serenegiant.usb.Size
import com.serenegiant.usb.UVCCamera
import java.util.Comparator

/**
 * Util class for finding best resolution for camera
 */
class ResolutionUtils {

    /**
     * Comparator for comparing the dimensions of two Size objects.
     */
    private class ResolutionComparator : Comparator<Size> {
        override fun compare(o1: Size, o2: Size): Int {
            return getDimensions(o1).compareTo(getDimensions(o2))
        }

        /**
         * Calculates the dimensions of a [Size] object.
         */
        private fun getDimensions(sizeIn: Size): Int {
            return sizeIn.width * sizeIn.height
        }
    }

    /**
     * Available format resolutions that are supported.
     */
    enum class Format(val size: android.util.Size) {
        // 16x9 ratio.
        F16x9(android.util.Size(16, 9));
    }

    companion object {
        private val CAMERA_FORMAT = Format.F16x9
        val EMPTY_SIZE = Size(0, 0, 0, 0, 0)

        /**
         * Find a valid resolution that the [camera] supports.
         */
        fun getResolution(camera: UVCCamera): Size {
            val possibleSizes: List<Size> = camera.supportedSizeList

            return possibleSizes.stream()
                .filter { size: Size -> size.type == 4 /* Video capture */ }
                .filter { size: Size -> this.matchesTargetRatio(size) }
                .max(ResolutionComparator()).orElse(
                    if (possibleSizes.isEmpty()) EMPTY_SIZE else possibleSizes.first()
                )
        }

        /**
         * Checks if a [size] matches the currently configured ratio.
         */
        private fun matchesTargetRatio(size: Size): Boolean {
            val formatSize: android.util.Size = CAMERA_FORMAT.size
            val scale = size.width / formatSize.width
            return scale * formatSize.height == size.height
        }
    }
}