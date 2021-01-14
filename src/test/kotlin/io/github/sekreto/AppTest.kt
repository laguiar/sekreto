package io.github.sekreto

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.File

open class AppTest {

    private val app = App()

    @Test
    fun testTableGeneration() {
        val response = app.generate()
        assertNotNull(response)
        assertTrue(response.hasEntity())
        assertTrue(response.entity is File)
    }

}