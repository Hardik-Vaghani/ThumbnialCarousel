package com.example.thumbnailcarousel.util.dimension

import android.content.Context
import kotlin.math.roundToInt
import java.math.BigDecimal
import java.math.RoundingMode
/**
 * ---------------------------------------------------------
 * Responsive Scaling Reference (Figma Base = 360dp)
 * ---------------------------------------------------------
 *
 *  FIGMA     SW320   SW360   SW411   SW480   SW600   SW720   SW840
 * ----------------------------------------------------------------
 *   12px  ->   11      12      13      14      16      18      22
 *
 *   14px  ->   13      14      15      17      18      21      25
 *
 *   16px  ->   15      16      18      19      21      24      29
 *
 *   24px  ->   23      24      26      28      31      36      43
 *
 *   32px  ->   30      32      35      38      42      48      58
 * ----------------------------------------------------------------
 *
 * Screen Buckets:
 *
 * SW320 -> Small Phones
 * SW360 -> Standard Phones (Base Design)
 * SW411 -> Large Phones
 * SW480 -> XL Phones / Foldables
 * SW600 -> Small Tablets
 * SW720 -> Large Tablets
 * SW840 -> Desktop / ChromeOS / Big Foldables
 *
 * ---------------------------------------------------------
 * Usage: High Precision Responsive Dimension System
 *
 * val padding = ResponsiveDimens.dp(context, 16f)
 *
 * textView.textSize =
 *     ResponsiveDimens.sp(context, 14f)
 *
 * ---------------------------------------------------------
 */

object ResponsiveDimens {

    /**
     * Returns HIGH PRECISION DP value
     *
     * Example:
     * 17.600000
     * 28.800000
     */
    fun dp(context: Context, value: Double, scale: Int = 6): Double {

        val bucket = ScreenBucket.from(context)

        return BigDecimal(value)
            .multiply(BigDecimal(bucket.dpScale))
            .setScale(scale, RoundingMode.HALF_UP)
            .toDouble()
    }

    /**
     * Returns HIGH PRECISION SP value
     */
    fun sp(context: Context, value: Double, scale: Int = 6): Double {

        val bucket = ScreenBucket.from(context)

        return BigDecimal(value)
            .multiply(BigDecimal(bucket.spScale))
            .setScale(scale, RoundingMode.HALF_UP)
            .toDouble()
    }

    /**
     * Convert to Int when needed
     */
    fun dpInt(context: Context, value: Double): Int {

        return dp(context, value).toInt()
    }

    /**
     * Convert to Float when needed
     */
    fun dpFloat(context: Context, value: Double): Float {

        return dp(context, value).toFloat()
    }
}
