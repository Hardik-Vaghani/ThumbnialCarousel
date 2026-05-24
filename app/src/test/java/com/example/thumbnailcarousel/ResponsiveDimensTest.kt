package com.example.thumbnailcarousel

import android.content.Context
import android.content.res.Configuration
import androidx.test.core.app.ApplicationProvider
import com.example.thumbnailcarousel.util.dimension.ResponsiveDimens
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ResponsiveDimensTest {

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
    fun test_sw320_scaling() {

        val context = createContext(320)

        assertEquals(
            15,
            ResponsiveDimens.dp(context, 16.0)
        )
    }

    @Test
    fun test_sw360_scaling() {

        val context = createContext(360)

        assertEquals(
            16,
            ResponsiveDimens.dp(context, 16.0)
        )
    }

    @Test
    fun test_sw411_scaling() {

        val context = createContext(411)

        assertEquals(
            18,
            ResponsiveDimens.dp(context, 16.0)
        )
    }

    @Test
    fun test_sw480_scaling() {

        val context = createContext(480)

        assertEquals(
            19,
            ResponsiveDimens.dp(context, 16.0)
        )
    }

    @Test
    fun test_sw600_scaling() {

        val context = createContext(600)

        assertEquals(
            21,
            ResponsiveDimens.dp(context, 16.0)
        )
    }

    @Test
    fun test_sw720_scaling() {

        val context = createContext(720)

        assertEquals(
            24,
            ResponsiveDimens.dp(context, 16.0)
        )
    }

    @Test
    fun test_sw840_scaling() {

        val context = createContext(840)

        assertEquals(
            29,
            ResponsiveDimens.dp(context, 16.0)
        )
    }
}