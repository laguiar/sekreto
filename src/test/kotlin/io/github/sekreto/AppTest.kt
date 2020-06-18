package io.github.sekreto

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Assertions
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