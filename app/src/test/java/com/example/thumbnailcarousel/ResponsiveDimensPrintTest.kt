package com.example.thumbnailcarousel

import android.content.Context
import android.content.res.Configuration
import androidx.test.core.app.ApplicationProvider
import com.example.thumbnailcarousel.util.dimension.ResponsiveDimens
import com.example.thumbnailcarousel.util.dimension.ScreenBucket
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ResponsiveDimensPrintTest {

    private fun createContext(
        smallestWidthDp: Int
    ): Context {

        val baseContext =
            ApplicationProvider.getApplicationContext<Context>()

        val configuration =
            Configuration(baseContext.resources.configuration)

        configuration.smallestScreenWidthDp =
            smallestWidthDp

        return baseContext.createConfigurationContext(
            configuration
        )
    }

    @Test
    fun print_all_scaling_values() {

//        val figmaValues = listOf(4f, 8f, 12f, 14f, 16f, 18f, 20f, 24f, 32f, 48f)
        val figmaValues = listOf(
            4.0,
            8.0,
            12.0,
            14.0,
            16.0,
            18.0,
            20.0,
            24.0,
            32.0,
            48.0
        )

        val buckets = listOf(
            ScreenBucket.SW320,
            ScreenBucket.SW360,
            ScreenBucket.SW411,
            ScreenBucket.SW480,
            ScreenBucket.SW600,
            ScreenBucket.SW720,
            ScreenBucket.SW840
        )

        println("")
        println("===================================================")
        println(" Responsive Scaling Output ")
        println("===================================================")
        println("")

        for (bucket in buckets) {

            val context =
                createContext(bucket.minWidthDp)

            println("-------------------------------------------")
            println(
                " ${bucket.name} " +
                        "(${bucket.minWidthDp}dp)"
            )
            println("-------------------------------------------")

            figmaValues.forEach { value ->

                val scaledDp =
                    ResponsiveDimens.dp(
                        context,
                        value
                    )

                val scaledSp =
                    ResponsiveDimens.sp(
                        context,
                        value
                    )

                println(
                    "Figma: ${value.toInt()}px " +
                            "-> DP: $scaledDp , " +
                            "SP: %.2f".format(scaledSp)
                )
            }

            println("")
        }

        println("===================================================")
    }
}