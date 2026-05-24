package com.example.thumbnailcarousel.util.dimension

import android.content.Context
import kotlin.math.roundToInt

/**
 * Responsive Screen Buckets
 *
 * Base Design:
 * Figma -> 360dp
 */
enum class ScreenBucket(
    val minWidthDp: Int,
    val dpScale: Double,
    val spScale: Double
) {

    /**
     * Small Phones
     */
    SW320(
        320,
        0.95,
        0.92
    ),

    /**
     * Standard Phones
     */
    SW360(
        360,
        1.00,
        1.00
    ),

    /**
     * Large Phones
     */
    SW411(
        411,
        1.10,
        1.05
    ),
    /**
     * XL Phones / Foldables
     */
    SW480(
    480,
    1.18,
    1.08
    ),

    /**
     * Small Tablets
     */
    SW600(
    600,
    1.30,
    1.15
    ),

    /**
     * Large Tablets
     */
    SW720(
    720,
    1.50,
    1.22
    ),

    /**
     * Desktop / ChromeOS / Big Foldables
     */
    SW840(
        840,
        1.80,
        1.30
    );

    companion object {

        fun from(context: Context): ScreenBucket {

            val widthDp =
                context.resources.configuration.smallestScreenWidthDp

            return when {

                widthDp >= SW840.minWidthDp -> SW840

                widthDp >= SW720.minWidthDp -> SW720

                widthDp >= SW600.minWidthDp -> SW600

                widthDp >= SW480.minWidthDp -> SW480

                widthDp >= SW411.minWidthDp -> SW411

                widthDp >= SW360.minWidthDp -> SW360

                else -> SW320
            }
        }
    }
}